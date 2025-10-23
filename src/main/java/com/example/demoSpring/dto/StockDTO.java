package com.example.demoSpring.dto;

public class StockDTO {
    private int stockId;
    private String stockName;
    private String symbol;
    private double price;

    public StockDTO() {}

    public StockDTO(int stockId, String stockName, String symbol, double price) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.symbol = symbol;
        this.price = price;
    }

    public int getStockId() { return stockId; }
    public void setStockId(int stockId) { this.stockId = stockId; }

    public String getStockName() { return stockName; }
    public void setStockName(String stockName) { this.stockName = stockName; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
