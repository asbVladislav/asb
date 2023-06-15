package com.example.demo.Service.db;

import com.example.demo.Entity.Rates;
import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.Repository.CurrencyRepository;
import com.example.demo.Repository.RatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AddArrayListRatesInBd {
    @Autowired
    private  RatesRepository exchangeRatesRepository;



    public void AddJsonsArrayInBD(ArrayList<RatesDto> data)
    {
        data.stream().map(d -> new Rates
                (
                        d.getCur_ID(), d.getCur_Name(),
                        d.getCur_OfficialRate(), d.getCur_Abbreviation(),
                        d.getDate(), d.getCur_Scale()
                )
        ).forEach(exchangeRatesRepository::save);

    }
}
