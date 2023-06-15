package com.example.demo.Service.db;

import com.example.demo.Entity.Currency;
import com.example.demo.Entity.Dto.CurrencyDto;
import com.example.demo.Repository.CurrencyRepository;
import com.example.demo.Repository.RatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AddArrayListCurrencyInBd {

    @Autowired
    private  CurrencyRepository currencyRepository;


    public void AddJsonsArrayInBD(ArrayList<CurrencyDto> data)
    {

        data.stream().map(d -> new Currency
                (
                        d.getCur_ID(), d.getCur_ParentID(),
                        d.getCur_Code(), d.getCur_Abbreviation(),
                        d.getCur_Name(), d.getCur_Name_Bel(),
                        d.getCur_Name_Eng(), d.getCur_QuotName(),
                        d.getCur_QuotName_Bel(), d.getCur_QuotName_Eng(),
                        d.getCur_NameMulti(), d.getCur_Name_BelMulti(),
                        d.getCur_Name_EngMulti(), d.getCur_Scale(),
                        d.getCur_Periodicity(), d.getCur_DateStart(),
                        d.getCur_DateEnd()
                        //,ratesRepository.findByCur_ID(d.getCur_ID())
                )
        ).forEach(currencyRepository::save);


        }
    }

