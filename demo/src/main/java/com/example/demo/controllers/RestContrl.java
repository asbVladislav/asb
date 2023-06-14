package com.example.demo.controllers;


import com.example.demo.Entity.Dto.CurrencyDto;
import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.Service.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;



@Controller
@ResponseBody
public class RestContrl
{
    private final AddArrayListCurrencyInBd addArrayListCurrencyInBd;

    private final GetArrayListCurrencyDto getArrayListCurrencyDto;

    Logger logger;

    @Value("${value.url.currency}")
    private String currencyUrl;






    @RequestMapping("/currency")
    public String getCurrencies() {
        try {
        ArrayList<CurrencyDto> jsons=getArrayListCurrencyDto.getJsonsArray(currencyUrl);
        logger.info("Currency get from url ");
        addArrayListCurrencyInBd.AddJsonsArrayInBD(jsons);
        logger.info("Currency add into database ");
            return "currencies added successfully";
        }
        catch (Throwable e){logger.error(e.getMessage());
            return "currencies NOT added successfully";}

    }


    public RestContrl( AddArrayListCurrencyInBd addArrayListCurrencyInBd , GetArrayListCurrencyDto getArrayListCurrencyDto) {
        this.addArrayListCurrencyInBd = addArrayListCurrencyInBd;
        this.getArrayListCurrencyDto = getArrayListCurrencyDto;
        logger = LoggerFactory.getLogger("Controller Logger");
    }
}
