package com.tfg.backend.data;

import java.text.SimpleDateFormat;
import java.util.List;

import com.tfg.backend.models.Loan;
import com.tfg.backend.models.User;

public abstract class NotificationMessages {

    public static final String NO_REPLY_MAIL = "no.reply.tracker.crawler@gmail.com";
    public static final String NO_REPLY_MAIL_TOKEN = "oecn rgwu sajm qtit";

    public static final String SESSION_NOTICE_TIME = "0 45 19 * * ?";
    public static final String LOAN_NOTICE_TIME = "0 08 20 * * ?";
    public static final String CADUCATED_LOAN_NOTICE_TIME = "0 05 22 * * ?";

    // SUBJECTS \\
    public static final String EMAIL_RECOVERY_SUBJECT = "🔑 Recuperación de Contraseña - TRACKER CRAWLER";
    public static final String SESSION_NOTICE_SUBJECT = "🔔🗓️📌 Próxima Sesión - TRACKER CRAWLER ";
    public static final String LOAN_EXPIRED_SUBJECT = "⚠️🔔🗓️ Préstamo a punto de expirar - TRACKER CRAWLER ";
    public static final String LOANS_CADUCATED_REPORT_SUBJECT = "🚨 Juegos pendientes de devolución";    
    
    
    public static String generateSessionReminderEmail(String userName, String sessionName, String sessionDate) {        
        return String.format("""
            <html>
                <body style="font-family: Arial, sans-serif; line-height: 1.6; color: #333; max-width: 600px; margin: 0 auto;">
                    <h2 style="color: #2c3e50;">¡Hola, %s!</h2>
                    <div style="background-color: #f8f9fa; padding: 20px; border-radius: 5px;">
                        <h2 style="color: #2c3e50; text-align: center;">🗓️ Recordatorio de Sesión</h2>
                                                
                        <p style="font-size: 16px;">Te recordamos que tienes una sesión programada para mañana:</p>
                        
                        <div style="background-color: #ffffff; border-left: 4px solid #3498db; padding: 15px; margin: 20px 0; border-radius: 0 5px 5px 0;">
                            <h3 style="margin-top: 0; color: #3498db;">%s</h3>
                            <p style="margin-bottom: 0;"><strong>📅 Fecha:</strong> %s</p>
                        </div>
                        
                        <p style="font-size: 16px;">¡No olvides prepararte para la sesión!</p>
                        
                        <div style="margin-top: 30px; padding-top: 20px; border-top: 1px solid #eee; text-align: center;">
                            <p style="font-size: 14px; color: #7f8c8d;">Este es un mensaje automático, por favor no respondas a este correo.</p>
                            <p style="font-size: 14px; color: #7f8c8d;">El equipo de <strong style="color: #3498db;">TRACKER CRAWLER</strong></p>
                        </div>
                    </div>
                </body>
            </html>
            """,userName, sessionName, sessionDate);
    }
    
    public static String generateRecoveryMessage(String username, String password) {        
        return String.format("""
            <html>
                <body style="font-family: Arial, sans-serif; line-height: 1.6; color: #333;">
                    <h2 style="color: #2c3e50;">¡Hola, %s!</h2>
                    
                    <p>Hemos recibido una solicitud para restablecer tu contraseña. Aquí tienes tu nueva contraseña temporal:</p>
                    
                    <div style="background-color: #f8f9fa; border-left: 4px solid #3498db; padding: 10px; margin: 15px 0;">
                        <strong style="font-size: 1.1em;">Contraseña temporal:</strong>
                        <span style="font-family: monospace; font-size: 1.2em; color: #e74c3c;">%s</span>
                    </div>
                    
                    <p>Por seguridad, te recomendamos:</p>
                    <ul>
                        <li>Cambiar esta contraseña al iniciar sesión.</li>
                        <li>No compartirla con nadie.</li>
                        <li>Usar una combinación de letras, números y símbolos.</li>
                    </ul>
                    
                    <p>Si no solicitaste este cambio, por favor contacta a soporte en trackercrawler@gmail.com.</p>
                    
                    <p style="margin-top: 20px;">Gracias,<br>El equipo de <span style="color: #3498db;">TRACKER CRAWLER</span></p>
                </body>
            </html>
            """, username, password);
    }

    public static String generateLoanReminderEmail(String userName, String hostUserName, String boardgameName, String formattedExpirationDate) {
        return String.format(
            "<html>" +
            "<body style=\"font-family: Arial, sans-serif; line-height: 1.6; color: #333; max-width: 600px; margin: 0 auto;\">" +
            "    <h2 style=\"color: #2c3e50;\">¡Hola, %s!</h2>" +
            "    <div style=\"background-color: #f8f9fa; padding: 20px; border-radius: 5px;\">" +
            "        <h2 style=\"color: #2c3e50; text-align: center;\">⚠️ Recordatorio de Devolución</h2>" +
            "        " +
            "        <p style=\"font-size: 16px;\">Te recordamos que mañana es la fecha límite para devolver este juego:</p>" +
            "        " +
            "        <div style=\"background-color: #ffffff; border-left: 4px solid #3498db; padding: 15px; margin: 20px 0; border-radius: 0 5px 5px 0;\">" +
            "            <h3 style=\"margin-top: 0; color: #3498db;\">%s</h3>" +
            "            <p><strong>👤 Debes devolverlo a:</strong> %s</p>" +
            "            <p style=\"margin-bottom: 0;\"><strong>📅 Fecha límite:</strong> %s</p>" +
            "        </div>" +
            "        " +
            "        <p style=\"font-size: 16px;\">Por favor, coordina la devolución a tiempo para que otros jugadores puedan disfrutarlo.</p>" +
            "        " +
            "        <div style=\"background-color: #fff3cd; padding: 12px; border-radius: 4px; margin: 15px 0; text-align: center;\">" +
            "            <p style=\"margin: 0;\">¿Ya lo has devuelto? ¡Notifícalo en la plataforma!</p>" +
            "        </div>" +
            "        " +
            "        <div style=\"margin-top: 30px; padding-top: 20px; border-top: 1px solid #eee; text-align: center;\">" +
            "            <p style=\"font-size: 14px; color: #7f8c8d;\">Este es un mensaje automático, por favor no respondas a este correo.</p>" +
            "            <p style=\"font-size: 14px; color: #7f8c8d;\">El equipo de <strong style=\"color: #3498db;\">TRACKER CRAWLER</strong></p>" +
            "        </div>" +
            "    </div>" +
            "</body>" +
            "</html>",
            userName, 
            boardgameName, 
            hostUserName, 
            formattedExpirationDate
        );
    }

    public static String generateExpiredLoansEmail(User owner, List<Loan> loans) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder loansList = new StringBuilder();
        loans.forEach(loan -> {
            String formattedDate = dateFormat.format(loan.getExpirationDate());
            loansList.append(NotificationMessages.generateEntryReportLoans(
                loan.getFkStock().getFkBoardgame().getBoardgameName(), 
                loan.getFkUser().getUserName(), 
                formattedDate)
            );
        });
        
        return String.format(
            "<html>" +
            "<body style=\"font-family: Arial, sans-serif; line-height: 1.6; color: #333; max-width: 600px; margin: 0 auto;\">" +
            "    <h2 style=\"color: #2c3e50;\">¡Hola, %s!</h2>" +
            "    <div style=\"background-color: #f8f9fa; padding: 20px; border-radius: 5px;\">" +
            "        <h2 style=\"color: #2c3e50; text-align: center;\">🚨 Juegos pendientes de devolución</h2>" +
            "        " +
            "        <p style=\"font-size: 16px;\">Los siguientes juegos de tu colección no fueron devueltos a tiempo:</p>" +
            "        " +
            "        %s" + 
            "        " +
            "        <p style=\"font-size: 16px;\">Por favor, contacta con los prestatarios para coordinar la devolución.</p>" +
            "        " +
            "        <div style=\"background-color: #fff3cd; padding: 12px; border-radius: 4px; margin: 15px 0; text-align: center;\">" +
            "            <p style=\"margin: 0;\">¿Ya te han devuelto algún juego? ¡Actualiza su estado en la plataforma!</p>" +
            "        </div>" +
            "        " +
            "        <div style=\"margin-top: 30px; padding-top: 20px; border-top: 1px solid #eee; text-align: center;\">" +
            "            <p style=\"font-size: 14px; color: #7f8c8d;\">Este es un mensaje automático, por favor no respondas a este correo.</p>" +
            "            <p style=\"font-size: 14px; color: #7f8c8d;\">El equipo de <strong style=\"color: #3498db;\">TRACKER CRAWLER</strong></p>" +
            "        </div>" +
            "    </div>" +
            "</body>" +
            "</html>",
            owner.getUserName(),
            loansList.toString()
        );
    }

    private static String generateEntryReportLoans(String boardgameName, String userName, String formattedExpirationDate) {
        return String.format(
            "<div style=\"background-color: #ffffff; border-left: 4px solid #e74c3c; padding: 15px; margin: 10px 0; border-radius: 0 5px 5px 0;\">" +
            "    <h3 style=\"margin-top: 0; color: #e74c3c;\">%s</h3>" +
            "    <p><strong>👤 Prestatario:</strong> %s</p>" +
            "    <p><strong>📅 Fecha límite incumplida:</strong> %s</p>" +
            "</div>",
            boardgameName,
            userName,
            formattedExpirationDate
        );
    }
}
