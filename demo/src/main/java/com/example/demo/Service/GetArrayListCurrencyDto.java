package com.example.demo.Service;

import com.example.demo.Configure.ProxyConfig;
import com.example.demo.Entity.Dto.CurrencyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class GetArrayListCurrencyDto  {
    @Autowired
    public ProxyConfig proxyConfig;

    public ArrayList<CurrencyDto> getJsonsArray(String url) {

        CurrencyDto[] jsons = new CurrencyDto[0];

        RestTemplate restTemplate=proxyConfig.restTemplate();

        jsons=restTemplate.getForObject(url,jsons.getClass());
        ArrayList<CurrencyDto> jsonArray = (ArrayList<CurrencyDto>) Arrays.stream(jsons).collect(Collectors.toList());


        return jsonArray ;

    }

}
