package com.example.crypto.mapper;

import com.example.crypto.model.Trade;
import com.example.crypto.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert({
            "<script>",
            "insert into public.trade (tradeID, symbol, openTime, openn, high, low, closee, volume, closeTime, quoteAssetVolume, " +
                    "numOfTrade, buyBase, buyQuote)",
            "values ",
            "<foreach  collection='tradeList' item='trade' separator=','>",
            "( #{trade.tradeID}, #{trade.symbol}, #{trade.openTime}, #{trade.openn}, #{trade.high}, #{trade.low}, #{trade.close}, #{trade.volume}," +
                    "#{trade.closeTime}, #{trade.quoteAssetVolume}, #{trade.numOfTrade}, #{trade.buyBase}, #{trade.buyQuote})",
            "</foreach>",
            "</script>"
    })
    int insertBatch(@Param("tradeList") List<Trade> tradeList);
}

//TODO: select data from my sql data table and map them onto web page


