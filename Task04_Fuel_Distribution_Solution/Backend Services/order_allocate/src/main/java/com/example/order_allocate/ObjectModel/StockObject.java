package com.example.order_allocate.ObjectModel;

public class StockObject {
    private int stockId;
    private String type;
    private double avalableStock;
    private double progress;

    public StockObject(int stockId, String type, double avalableStock, double progress) {
        this.stockId = stockId;
        this.type = type;
        this.avalableStock = avalableStock;
        this.progress = progress;
    }

    public StockObject() {

    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAvalableStock() {
        return avalableStock;
    }

    public void setAvalableStock(double avalableStock) {
        this.avalableStock = avalableStock;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
