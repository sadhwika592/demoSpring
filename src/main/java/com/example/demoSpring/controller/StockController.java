package com.example.demoSpring.controller;

import com.example.demoSpring.dto.StockDTO;
import com.example.demoSpring.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/page/{pageNum}/size/{pageSize}")
    public List<StockDTO> getPaginatedStocks(
            @PathVariable int pageNum,
            @PathVariable int pageSize) {
        return stockService.getPaginatedStocks(pageNum, pageSize);
    }

    @PostMapping
    public String addStock(@RequestBody StockDTO stock) {
        return stockService.addStock(stock);
    }
}
