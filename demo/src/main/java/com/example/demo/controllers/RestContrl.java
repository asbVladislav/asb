package com.example.demo.controllers;


import com.example.demo.Entity.Dto.CurrencyDto;
import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.Service.*;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;



@Controller
@ResponseBody
public class RestContrl
{
    private final AddArrayListRatesInBd addArrayListRatesInBd;
    private final AddArrayListCurrencyInBd addArrayListCurrencyInBd;
    private final GetArrayListRatesDto getArrayListRatesDto;
    private final GetArrayListCurrencyDto getArrayListCurrencyDto;

    @Value("${value.url.currency}")
    private String currencyUrl;
    @Value("${value.url.dailyrate}")
    private String dailyRateUrl;
    @Value("${value.url.monthlyrate}")
private String monthlyRateUrl;


    public RestContrl(AddArrayListRatesInBd addArrayListRatesInBd, AddArrayListCurrencyInBd addArrayListCurrencyInBd , GetArrayListRatesDto getArrayListRatesDto, GetArrayListCurrencyDto getArrayListCurrencyDto) {
        this.addArrayListRatesInBd = addArrayListRatesInBd;
        this.addArrayListCurrencyInBd = addArrayListCurrencyInBd;
        this.getArrayListRatesDto = getArrayListRatesDto;
        this.getArrayListCurrencyDto = getArrayListCurrencyDto;
    }


    @Scheduled(fixedRateString = "${month}")
    public void getMonthlyRates() {

        ArrayList<RatesDto> jsons=getArrayListRatesDto.getJsonsArray(monthlyRateUrl);
        addArrayListRatesInBd.AddJsonsArrayInBD(jsons);
System.out.println("getMonthlyRates complete "+ LocalDateTime.now());

    }
    @Scheduled(fixedRateString = "${day}")
    public void getDailyRates() {

        ArrayList<RatesDto> jsons=getArrayListRatesDto.getJsonsArray(dailyRateUrl);
        addArrayListRatesInBd.AddJsonsArrayInBD(jsons);
        System.out.println("getDailyRates complete "+ LocalDateTime.now());
    }
    @RequestMapping("/currency")
    public String getCurrencies() {

        ArrayList<CurrencyDto> jsons=getArrayListCurrencyDto.getJsonsArray(currencyUrl);
        addArrayListCurrencyInBd.AddJsonsArrayInBD(jsons);

        return "currencies added successfully";
    }



}
