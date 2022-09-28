package com.example.crypto.controller;

import com.example.crypto.mapper.UserMapper;
import com.example.crypto.model.Trade;
import com.example.crypto.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoadController {

    @Autowired
    private LoadService service;

    @GetMapping("/v1/klines")
    @ResponseBody
    public int getSymbol(@RequestParam String symbol, @RequestParam Long startTime, @RequestParam Long endTime) {
        return service.load(symbol, startTime, endTime);
    }


//
//    @GetMapping(path = "/get")
//    public List<Trade> testRestTemplateGet(){
//        return service.load(getSymbol(), getStartTime(), getEndTime());
//    }
}

    /**
     * @RequestMapping(value = "/template/products")
     *     public String getProductList() {
     *         HttpHeaders headers = new HttpHeaders();
     *         headers.setArrays(Arrays.asList(MediaType.APPLICATION_JSON));
     *         HttpEntity<String> entity = new HttpEntity<String>(headers);
     *
     *         return restTemplate.exchange(
     *                 "https://binance-docs.github.io/apidocs/spot/en/#kline-candlestick-data", HttpMethod.GET, entity, String.class).getBody();
     *     }
     *
     */


    //TODO create a database table for https://binance-docs.github.io/apidocs/spot/en/#kline-candlestick-data
        // TODO use rest template to call https://www.binance.com/api/v1/klines?symbol=BTCUSDT&interval=1m&startTime=1523577600000&endTime=1523664000000
    //
//    [
//            [
//            1499040000000,      // Open time
//            "0.01634790",       // Open
//            "0.80000000",       // High
//            "0.01575800",       // Low
//            "0.01577100",       // Close
//            "148976.11427815",  // Volume
//            1499644799999,      // Close time
//            "2434.19055334",    // Quote asset volume
//            308,                // Number of trades
//            "1756.87402397",    // Taker buy base asset volume
//            "28.46694368",      // Taker buy quote asset volume
//            "17928899.62484339" // Ignore.
//            ]
//            ]
    // TODO after get the data from rest template (reference https://www.baeldung.com/rest-template, https://www.tutorialspoint.com/spring_boot/spring_boot_rest_template.htm )
    //  use mybatis to save the data into the database

