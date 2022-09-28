package com.example.crypto.controller;

import com.example.crypto.model.Trade;
import com.example.crypto.service.RetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ControllerWithInterval {

    @Autowired
    private RetrieveService service;

    @RequestMapping(value = "/obtain", method = RequestMethod.GET)

    public List<Trade> aggregateTrade(String symbol, long start, long end, int interval) {
        return service.aggregateTrade(symbol, start, end, interval);
    }
}
