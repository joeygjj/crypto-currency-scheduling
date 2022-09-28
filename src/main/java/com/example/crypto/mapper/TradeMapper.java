package com.example.crypto.mapper;

import com.example.crypto.model.Trade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TradeMapper{
    @Results({
            @Result(property = "tradeID", column = "tradeid"),
            @Result(property = "symbol", column = "symbol"),
            @Result(property = "openTime", column = "openTime"),
            @Result(property = "openn", column = "openn"),
            @Result(property = "high", column = "high"),
            @Result(property = "low", column = "low"),
            @Result(property = "close", column = "closee"),
            @Result(property = "volume", column = "volume"),
            @Result(property = "closeTime", column = "closeTime"),
            @Result(property = "quoteAssetVolume", column = "quoteAssetVolume"),
            @Result(property = "numOfTrade", column = "numOfTrade"),
            @Result(property = "buyBase", column = "buyBase"),
            @Result(property = "buyQuote", column = "buyQuote")
    })
    @Select("SELECT tradeid, symbol, openTime, openn, high, low, closee, volume, closeTime, quoteAssetVolume, numOfTrade, buyBase, buyQuote\n" +
            "FROM   trade\n" +
            "WHERE  opentime BETWEEN #{start}\n" +
            "                 AND #{end};")
    List<Trade> selectTrade(String symbol, long start, long end);

}
