package com.example.stockui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StocksModel {
    public StocksModel() {
    }

    public StocksModel(String stockName, String currentPrice, String dayChangeP, String yearChangeP) {
        this.stockName = stockName;
        this.currentPrice = currentPrice;
        this.dayChangeP = dayChangeP;
        this.yearChangeP = yearChangeP;
    }

    int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @SerializedName("stockName")
    @Expose
    private String stockName;

    @SerializedName("currentPrice")
    @Expose
    private String currentPrice;

    @SerializedName("dayChangeP")
    @Expose
    private String dayChangeP;

    @SerializedName("yearChangeP")
    @Expose
    private String yearChangeP;


    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getDayChangeP() {
        return dayChangeP;
    }

    public void setDayChangeP(String dayChangeP) {
        this.dayChangeP = dayChangeP;
    }

    public String getYearChangeP() {
        return yearChangeP;
    }

    public void setYearChangeP(String yearChangeP) {
        this.yearChangeP = yearChangeP;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

}
