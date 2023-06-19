package com.example.demo.controllers;


import com.example.demo.Entity.Dto.CurrencyDto;
import com.example.demo.Entity.Sends.SendAll;
import com.example.demo.Entity.Sends.SendNameRateScaleAbbrev;
import com.example.demo.Entity.Rates;
import com.example.demo.Entity.Sends.SendNameRateScaleAbbrevDate;
import com.example.demo.Repository.CurrencyRepository;
import com.example.demo.Repository.RatesRepository;
import com.example.demo.Service.*;


import com.example.demo.Service.db.AddArrayListCurrencyInBd;
import com.example.demo.Service.getByUrl.GetArrayListCurrencyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.Arrays;
@Tag(name="Контроллер получения", description="Контроллер для получения данных и БД")
@RestController
public class RestContrl
{

    private  final RatesRepository ratesRepository;
    private  final CurrencyRepository currencyRepository;


    Logger logger;





    @Operation(
            summary = "Получение кратких курсов валют",
            description = "Позволяет получить подробную информацию о каждой валюте по дате"
    )
    @GetMapping("/rates")
    public ResponseEntity<?> getRatesByDate( @RequestParam  @Parameter(description = "Дата с которой будут выбраны валюты") String date){
        try {
            DateParser dateParser=new DateParser("y-MM-dd");
            Rates[] rates = ratesRepository.findByDate(dateParser.parse(date));

            SendNameRateScaleAbbrev[] sendJsonDto=Arrays.stream(rates).map(d -> new SendNameRateScaleAbbrev(d.getCur_Name(),d.getCur_OfficialRate(),d.getCur_Abbreviation(),d.getCur_Scale())).toArray(SendNameRateScaleAbbrev[]::new);

            return new ResponseEntity<>(sendJsonDto, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @Operation(
            summary = "Получение кратких курсов валют в рамках периода",
            description = "Позволяет получить подробную информацию о каждой валюте в рамках некоторого периода"
    )
    @GetMapping("/ratesperiod")
    public ResponseEntity<?> getRatesPeriodByDate( @RequestParam @Parameter(description = "Начало периода с которого будут выбраны валюты") String startperiod,@RequestParam @Parameter(description = "Конец периода с которого будут выбраны валюты") String endperiod){

        try {
            DateParser dateParser=new DateParser("y-MM-dd");

            Rates[] rates = ratesRepository.findByPeriod(dateParser.parse(startperiod),dateParser.parse(endperiod));

            SendNameRateScaleAbbrevDate[] sendJsonDto=Arrays.stream(rates).map(d -> new SendNameRateScaleAbbrevDate(d.getCur_Name(),d.getCur_OfficialRate(),d.getCur_Abbreviation(),d.getCur_Scale(),d.getDate())).toArray(SendNameRateScaleAbbrevDate[]::new);

            return new ResponseEntity<>(sendJsonDto, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Получение полных курсов валют",
            description = "Позволяет полных подробную информацию о каждой валюте по дате"
    )
    @GetMapping("/allrates")
    public ResponseEntity<?> getRatesByDateAll( @RequestParam  @Parameter(description = "Дата с которой будут выбраны валюты") String date){

        try {
            DateParser dateParser=new DateParser("y-MM-dd");
            Rates[] rates = ratesRepository.findByDate(dateParser.parse(date));

            SendAll[] sendJsonDto=Arrays.stream(rates).map(d -> new SendAll(currencyRepository.findByCur_ID(d.getCur_ID()).getCur_ID() ,currencyRepository.findByCur_ID(d.getCur_ID()).getCur_ParentID() ,currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Code(), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Abbreviation(), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Name() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Name_Bel() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Name_Eng(), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_QuotName(), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_QuotName_Bel() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_QuotName_Eng (), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_NameMulti() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Name_BelMulti(), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Name_EngMulti() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Scale() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Periodicity (), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_DateStart (), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_DateEnd(), d.getCur_OfficialRate())
                    ).toArray(SendAll[]::new);

            return new ResponseEntity<>(sendJsonDto, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(
            summary = "Получение полных курсов валют в рамках периода",
            description = "Позволяет полных подробную информацию о каждой валюте в рамках некоторого периода"
    )
    @GetMapping("/allratesperiod")
    public ResponseEntity<?> getRatesPeriodByDateAll(@RequestParam @Parameter(description = "Начало периода с которого будут выбраны валюты") String startperiod, @RequestParam @Parameter(description = "Конец периода с которого будут выбраны валюты") String endperiod){

        try {
            DateParser dateParser=new DateParser("y-MM-dd");

            Rates[] rates = ratesRepository.findByPeriod(dateParser.parse(startperiod),dateParser.parse(endperiod));

            SendAll[] sendJsonDto=Arrays.stream(rates).map(d -> new SendAll(currencyRepository.findByCur_ID(d.getCur_ID()).getCur_ID() ,currencyRepository.findByCur_ID(d.getCur_ID()).getCur_ParentID() ,currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Code(), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Abbreviation(), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Name() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Name_Bel() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Name_Eng(), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_QuotName(), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_QuotName_Bel() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_QuotName_Eng (), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_NameMulti() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Name_BelMulti(), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Name_EngMulti() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Scale() , currencyRepository.findByCur_ID(d.getCur_ID()).getCur_Periodicity (), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_DateStart (), currencyRepository.findByCur_ID(d.getCur_ID()).getCur_DateEnd(), d.getCur_OfficialRate())
            ).toArray(SendAll[]::new);

            return new ResponseEntity<>(sendJsonDto, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





    public RestContrl( RatesRepository ratesRepository, CurrencyRepository currencyRepository) {
        this.ratesRepository = ratesRepository;
        this.currencyRepository = currencyRepository;
        logger = LoggerFactory.getLogger("Controller Logger");
    }
}
