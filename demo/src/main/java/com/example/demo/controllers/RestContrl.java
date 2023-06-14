package com.example.demo.controllers;


import com.example.demo.Entity.Dto.CurrencyDto;
import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.Service.*;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping("/monthlyrate")
    public String getMonthlyRates() {

        ArrayList<RatesDto> jsons=getArrayListRatesDto.getJsonsArray(monthlyRateUrl);
        addArrayListRatesInBd.AddJsonsArrayInBD(jsons);

        return "monthly daily rates added successfully";
    }
    @RequestMapping("/dailyrate")
    public String getDailyRates() {

        ArrayList<RatesDto> jsons=getArrayListRatesDto.getJsonsArray(dailyRateUrl);
        addArrayListRatesInBd.AddJsonsArrayInBD(jsons);

        return "daily rates added successfully";
    }
    @RequestMapping("/currency")
    public String getCurrencies() {

        ArrayList<CurrencyDto> jsons=getArrayListCurrencyDto.getJsonsArray(currencyUrl);
        addArrayListCurrencyInBd.AddJsonsArrayInBD(jsons);

        return "currencies added successfully";
    }



}
