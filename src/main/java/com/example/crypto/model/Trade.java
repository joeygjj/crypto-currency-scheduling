package com.example.crypto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Trade {
    private int tradeID;
    private String symbol;
    private Long openTime;
    private Double openn;
    private Double high;
    private Double low;
    private Double close;
    private Double volume;
    private Long closeTime;
    private Double quoteAssetVolume;
    private Integer numOfTrade;
    private Double buyBase;
    private Double buyQuote;


    public int getTradeID() {
        return tradeID;
    }

    public void setTradeID(int tradeID) {
        this.tradeID = tradeID;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public Double getOpenn() {
        return openn;
    }

    public void setOpenn(Double openn) {
        this.openn = openn;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public Double getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    public void setQuoteAssetVolume(Double quoteAssetVolume) {
        this.quoteAssetVolume = quoteAssetVolume;
    }

    public Integer getNumOfTrade() {
        return numOfTrade;
    }

    public void setNumOfTrade(Integer numOfTrade) {
        this.numOfTrade = numOfTrade;
    }

    public Double getBuyBase() {
        return buyBase;
    }

    public void setBuyBase(Double buyBase) {
        this.buyBase = buyBase;
    }

    public Double getBuyQuote() {
        return buyQuote;
    }

    public void setBuyQuote(Double buyQuote) {
        this.buyQuote = buyQuote;
    }
}
