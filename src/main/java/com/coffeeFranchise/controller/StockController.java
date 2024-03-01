package com.coffeeFranchise.controller;

import com.coffeeFranchise.model.Stock;
import com.coffeeFranchise.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public class StockController {

    private final StockRepository stockRepository;

    public StockController(@Autowired StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Integer id) {
        return stockRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Integer id, @RequestBody Stock stockDetails) {
        return stockRepository.findById(id)
                .map(stock -> {
                    stock.setBeanName(stockDetails.getBeanName());
                    stock.setBeanType(stockDetails.getBeanType());
                    stock.setFranchise(stockDetails.getFranchise());
                    Stock updatedStock = stockRepository.save(stock);
                    return ResponseEntity.ok(updatedStock);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable Integer id) {
        return stockRepository.findById(id)
                .map(stock -> {
                    stockRepository.delete(stock);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}