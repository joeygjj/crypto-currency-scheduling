package com.example.crypto.controller;

import com.example.crypto.model.Trade;
import com.example.crypto.service.RetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class RetrieveController {

    @Autowired
    private RetrieveService service;

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)

    public List<Trade> selectTrade(@RequestParam String symbol, @RequestParam Long start, @RequestParam Long end){
        return service.selectTrade(symbol, start, end);
    }
}

//TODO: new controller with interval

//TODO: input start time, end time (retrieve)