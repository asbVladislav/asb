package com.example.demo.Schedule;

import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.Service.AddArrayListRatesInBd;
import com.example.demo.Service.GetArrayListRatesDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class Schedule {
    private final AddArrayListRatesInBd addArrayListRatesInBd;
    private final GetArrayListRatesDto getArrayListRatesDto;
    Logger logger;

    @Value("${value.url.dailyrate}")
    private String dailyRateUrl;
    @Value("${value.url.monthlyrate}")
    private String monthlyRateUrl;

    public Schedule(AddArrayListRatesInBd addArrayListRatesInBd, GetArrayListRatesDto getArrayListRatesDto) {
        this.addArrayListRatesInBd = addArrayListRatesInBd;
        this.getArrayListRatesDto = getArrayListRatesDto;
         logger = LoggerFactory.getLogger("Schedule Logger");
    }



    @Scheduled(fixedRateString = "${month}")
    public void getMonthlyRates() {
        try {
            ArrayList<RatesDto> jsons = getArrayListRatesDto.getJsonsArray(monthlyRateUrl);
            logger.info("Monthly Rates get from url ");
            addArrayListRatesInBd.AddJsonsArrayInBD(jsons);
            logger.info("Monthly Rates add into database ");
        }
        catch (Throwable e){logger.error(e.getLocalizedMessage(),e.getMessage());}
    }
    @Scheduled(fixedRateString = "${day}")
    public void getDailyRates() {
        try{
        ArrayList<RatesDto> jsons=getArrayListRatesDto.getJsonsArray(dailyRateUrl);
        logger.info("Daily Rates get from url");
        addArrayListRatesInBd.AddJsonsArrayInBD(jsons);
        logger.info("Daily Rates add into database ");}
        catch (Throwable e){logger.error(e.getLocalizedMessage(),e.getMessage());}
    }
}
