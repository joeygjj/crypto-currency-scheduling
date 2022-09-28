package com.example.crypto.service;

import com.example.crypto.mapper.UserMapper;
import com.example.crypto.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LoadService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserMapper mapper;

    @Value("${urltemplate}")
    private String urlTemplate;

    public int load(String symbol, Long startTime, Long endTime){
        int id = (int)(Math.random() * Integer.MAX_VALUE);
        Long i = startTime;
        long fiveHundreds = 500 * 60 * 1000L;
        while(i <= endTime){
            long currEnd = i + fiveHundreds;
            currEnd = currEnd < endTime ? currEnd : endTime;
            loadOneTime(id, symbol, i, currEnd);
            i = currEnd;
        }
        return id;
    }

    private int loadOneTime(int id,String symbol, Long startTime, Long endTime) {
        List<Trade> list = new ArrayList<>();
        //TODO tradeid + symbol + openn + closee
        String url = String.format(urlTemplate, symbol, startTime, endTime);
        String[][] forObject = restTemplate.getForObject(url, String[][].class);
        for (String[] data : forObject) {
            Trade trade = new Trade();
            trade.setTradeID(id);
            trade.setSymbol(symbol);
            trade.setOpenTime(Long.parseLong(data[0]));
            trade.setOpenn(Double.parseDouble(data[1]));
            trade.setHigh(Double.parseDouble(data[2]));
            trade.setLow(Double.parseDouble(data[3]));
            trade.setClose(Double.parseDouble(data[4]));
            trade.setVolume(Double.parseDouble(data[5]));
            trade.setCloseTime(Long.parseLong(data[6]));
            trade.setQuoteAssetVolume(Double.parseDouble(data[7]));
            trade.setNumOfTrade(Integer.parseInt(data[8]));
            trade.setBuyBase(Double.parseDouble(data[9]));
            trade.setBuyQuote(Double.parseDouble(data[10]));
            list.add(trade);
        }
        mapper.insertBatch(list);
        return id;
    }
}
