package com.example.crypto.service;

import com.example.crypto.mapper.TradeMapper;
import com.example.crypto.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetrieveService{
    @Autowired
    private TradeMapper mapper;

    public List<Trade> selectTrade(String symbol, long start, long end){
        return mapper.selectTrade(symbol, start, end);
    }
//5min each interval
    public List<Trade> aggregateTrade(String symbol, long start, long end, int interval){
        List<Trade> result = new ArrayList<>();
        List<Trade> list = selectTrade(symbol, start, end);
        for(int i = 0; i < list.size(); i+= 5){
            Trade oneSet = new Trade();
            oneSet.setTradeID(list.get(i).getTradeID());
            oneSet.setSymbol(list.get(i).getSymbol());
            oneSet.setOpenTime(list.get(i).getOpenTime());
            double openSum = 0;
            double highSum = 0;
            double lowSum  = 0;
            double closeSum = 0;
            double volumeSum = 0;
            double quoteAssetSum = 0;
            int numOfTradeSum = 0;
            double buyBaseSum = 0;
            double buyQuoteSum = 0;
            for(int j = i; j < i + 5; j++){
                openSum += list.get(j).getOpenn();
                closeSum += list.get(j).getClose();
                highSum += list.get(j).getHigh();
                lowSum += list.get(j).getLow();
                volumeSum += list.get(j).getVolume();
                quoteAssetSum += list.get(j).getQuoteAssetVolume();
                numOfTradeSum += list.get(j).getNumOfTrade();
                buyBaseSum += list.get(j).getBuyBase();
                buyQuoteSum += list.get(j).getBuyQuote();
            }
            oneSet.setOpenn(openSum);
            oneSet.setHigh(highSum);
            oneSet.setLow(lowSum);
            oneSet.setClose(closeSum);
            oneSet.setVolume(volumeSum);
            oneSet.setQuoteAssetVolume(quoteAssetSum);
            oneSet.setNumOfTrade(numOfTradeSum);
            oneSet.setBuyBase(buyBaseSum);
            oneSet.setBuyQuote(buyQuoteSum);
            oneSet.setCloseTime(list.get(i + 4).getCloseTime());
            result.add(oneSet);
        }
        return result;
    }
}