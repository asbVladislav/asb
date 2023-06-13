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
    @Value("${value.url.rate}")
    private String rateUrl;


    public RestContrl(AddArrayListRatesInBd addArrayListRatesInBd, AddArrayListCurrencyInBd addArrayListCurrencyInBd , GetArrayListRatesDto getArrayListRatesDto, GetArrayListCurrencyDto getArrayListCurrencyDto) {
        this.addArrayListRatesInBd = addArrayListRatesInBd;
        this.addArrayListCurrencyInBd = addArrayListCurrencyInBd;
        this.getArrayListRatesDto = getArrayListRatesDto;
        this.getArrayListCurrencyDto = getArrayListCurrencyDto;
    }



    @PostMapping("/rate")
    public String getCurrencies() {

        ArrayList<RatesDto> jsons=getArrayListRatesDto.getJsonsArray(rateUrl);
        addArrayListRatesInBd.AddJsonsArrayInBD(jsons);

        return "currencies added successfully";
    }
    @RequestMapping("/currency")
    public String getRates() {

        ArrayList<CurrencyDto> jsons=getArrayListCurrencyDto.getJsonsArray(currencyUrl);
        addArrayListCurrencyInBd.AddJsonsArrayInBD(jsons);

        return "rates added successfully";
    }



}
