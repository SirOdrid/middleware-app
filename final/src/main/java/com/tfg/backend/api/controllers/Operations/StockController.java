package com.tfg.backend.api.controllers.Operations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tfg.backend.api.request.StockRequest;
import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.Stock;
import com.tfg.backend.services.operations.StockService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_STOCK)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @CrossOrigin
    @PostMapping(ApiConfig.ENDPOINT_STOCK_ADD)
    public ResponseEntity<?> addStock(@Valid @RequestBody StockRequest stock) {
        stockService.addStock(stock);
        return new ResponseEntity<>(HttpStatus.CREATED); 
    }

    @CrossOrigin
    @PutMapping(ApiConfig.ENDPOINT_STOCK_UPDATE)
    public ResponseEntity<?> updateStock(@PathVariable(ApiConfig.PATH_STOCK_ID) Integer stockId, @RequestBody StockRequest stock) {
        stockService.updateStock(stockId, stock);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(ApiConfig.ENDPOINT_STOCK_DELETE)
    public ResponseEntity<?> deleteStock(@PathVariable(ApiConfig.PATH_STOCK_ID) Integer stockId) {
        stockService.deleteStock(stockId);
        return new ResponseEntity<>(HttpStatus.OK); 
    }

    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_STOCK_ALL_BY_USER)
    public ResponseEntity<?> getAllStocksByUser(@PathVariable(ApiConfig.PATH_USER_ID) Integer userId) {
        List<Stock> stocks = stockService.getAllStocksByUser(userId);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
}
