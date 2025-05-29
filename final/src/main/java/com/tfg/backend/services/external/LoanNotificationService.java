package com.tfg.backend.services.external;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.backend.api.request.LoanRequest;
import com.tfg.backend.data.NotificationMessages;
import com.tfg.backend.models.Loan;
import com.tfg.backend.models.User;
import com.tfg.backend.repository.LoanRepository;
import com.tfg.backend.repository.LoanStateRepository;
import com.tfg.backend.services.operations.LoanService;

@Service
public class LoanNotificationService {

    @Autowired
    private LoanService loanService;
    
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanStateRepository loanStateRepository;

    @Transactional
    @Scheduled(cron = NotificationMessages.LOAN_NOTICE_TIME) 
    public void sendLoanReminders() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        List<Loan> loans = loanRepository.findByExpirationDate(tomorrow);
        loans.forEach(this::sendReminderForLoan);
    }

    @Transactional
    @Scheduled(cron = NotificationMessages.CADUCATED_LOAN_NOTICE_TIME) 
    public void sendCaducatedLoanReport() {
        List<Loan> expiredLoans = loanRepository.findExpiredLoans();

        //recorrer listado de expiredLoans
        for (Loan loan : expiredLoans) {
            loanService.updateLoan(loan.getLoanId(), new LoanRequest(
                loan.getLoanDate(), 
                loan.getExpirationDate(), 
                loan.getFkUser().getUserId(), 
                loan.getFkStock().getStockId(), 
                loanStateRepository.findByLoanStateName("retraso").getLoanStateId()
            ));
        }


        Map<User, List<Loan>> loansByOwner = expiredLoans.stream()
            .collect(Collectors.groupingBy(loan -> loan.getFkStock().getFkUser()));
        
        // Enviar notificación a cada dueño
        loansByOwner.forEach((owner, loans) -> {
            if (owner.isEmailNotifications()) {
                String emailContent = NotificationMessages.generateExpiredLoansEmail(owner, loans);
                EmailSenderService.sendEmail(
                    owner.getEmail(),
                    NotificationMessages.LOANS_CADUCATED_REPORT_SUBJECT,
                    emailContent
                );
            }
        });
    }

    private void sendReminderForLoan(Loan loan) {
        User user = loan.getFkUser();
        if (user.isEmailNotifications()) {
            String userName = user.getUserName();
            String hostUserName = loan.getFkStock().getFkUser().getUserName();
            String boardgameName = loan.getFkStock().getFkBoardgame().getBoardgameName();
            Date expirationDate = loan.getExpirationDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String formattedExpirationDate = dateFormat.format(expirationDate);
            String subject = NotificationMessages.LOAN_EXPIRED_SUBJECT;
            String body = NotificationMessages.generateLoanReminderEmail(
                userName,
                hostUserName,
                boardgameName,
                formattedExpirationDate
            );
            EmailSenderService.sendEmail(user.getEmail(), subject, body);
        }
    }
}
