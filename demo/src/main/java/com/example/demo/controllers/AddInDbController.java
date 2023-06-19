package com.example.demo.controllers;


import com.example.demo.Entity.Dto.CurrencyDto;
import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.Service.db.AddArrayListCurrencyInBd;
import com.example.demo.Service.db.AddArrayListRatesInBd;
import com.example.demo.Service.getByUrl.GetArrayListCurrencyDto;
import com.example.demo.Service.getByUrl.GetArrayListRatesDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Tag(name="Контроллер добавления", description="Контроллер для добавления данных в БД")
@RestController
public class AddInDbController
{
    private final AddArrayListCurrencyInBd addArrayListCurrencyInBd;

    private final GetArrayListCurrencyDto getArrayListCurrencyDto;


    private final AddArrayListRatesInBd addArrayListRatesInBd;
    private final GetArrayListRatesDto getArrayListRatesDto;
    Logger logger;

    @Value("${value.url.dailyrate}")
    private String dailyRateUrl;
    @Value("${value.url.monthlyrate}")
    private String monthlyRateUrl;
    @Value("${value.url.currency}")
    private String currencyUrl;




    @Operation(
            summary = "Обновление ежедневного перечня валют",
            description = "Данное обновление делается каждый день, данные иетод может вызываться в случае сбоя"
    )
    @PostMapping("admin/dailyrates")
    public String getDailyRates() {
        try{
            ArrayList<RatesDto> jsons=getArrayListRatesDto.getJsonsArray(dailyRateUrl);
            logger.info("Daily Rates get from url");
            addArrayListRatesInBd.AddJsonsArrayInBD(jsons);
            logger.info("Daily Rates add into database ");
        return "Daily Rates added successfully";
    }
        catch (Throwable e){logger.error(e.getMessage());
    return "Daily Rates NOT added successfully";}
}





    @Operation(
            summary = "Обновление ежемесячного перечня валют",
            description = "Данное обновление делается каждые 30 дней, данные иетод может вызываться в случае сбоя"
    )
    @PostMapping("admin/monthlyrates")
    public String getMonthlyRates() {
        try {
            ArrayList<RatesDto> jsons = getArrayListRatesDto.getJsonsArray(monthlyRateUrl);
            logger.info("Monthly Rates get from url ");
             addArrayListRatesInBd.AddJsonsArrayInBD(jsons);
            logger.info("Monthly Rates add into database ");

        return "Monthly Rates added successfully";
    }
        catch (Throwable e){logger.error(e.getMessage());
    return "Monthly Rates NOT added successfully";}
    }






    @Operation(
            summary = "Добавление полного перечня валют",
            description = "Данное обновление делается один раз, в начале работы программы"
    )
    @PostMapping("admin/currency")
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


    public AddInDbController(AddArrayListCurrencyInBd addArrayListCurrencyInBd , GetArrayListCurrencyDto getArrayListCurrencyDto, AddArrayListRatesInBd addArrayListRatesInBd, GetArrayListRatesDto getArrayListRatesDto) {
        this.addArrayListCurrencyInBd = addArrayListCurrencyInBd;
        this.getArrayListCurrencyDto = getArrayListCurrencyDto;
        this.addArrayListRatesInBd = addArrayListRatesInBd;
        this.getArrayListRatesDto = getArrayListRatesDto;
        logger = LoggerFactory.getLogger("Controller Logger");
    }
}
