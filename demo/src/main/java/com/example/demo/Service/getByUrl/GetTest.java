package com.example.demo.Service.getByUrl;

import com.example.demo.Configure.ProxyConfig;
import com.example.demo.Entity.Dto.RatesDto;
import com.example.demo.Entity.Sends.SendAll;
import com.example.demo.Entity.Sends.SendNameRateScaleAbbrev;
import com.example.demo.Entity.Sends.SendNameRateScaleAbbrevDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class GetTest {

    @Autowired
    public ProxyConfig proxyConfig;

    public ArrayList<SendAll> getJsonsArray1(String url) {

        SendAll[] jsons = new SendAll[0];

        //RestTemplate restTemplate=proxyConfig.restTemplate();
        RestTemplate restTemplate=proxyConfig.restTemplateWithoutProxy();
        jsons=restTemplate.getForObject(url,jsons.getClass());
        ArrayList<SendAll> JsonArray = (ArrayList<SendAll>) Arrays.stream(jsons).collect(Collectors.toList());


        return JsonArray ;

    }
    public ArrayList<SendNameRateScaleAbbrev> getJsonsArray2(String url) {

        SendNameRateScaleAbbrev[] jsons = new SendNameRateScaleAbbrev[0];
        RestTemplate restTemplate=proxyConfig.restTemplateWithoutProxy();

        jsons=restTemplate.getForObject(url,jsons.getClass());
        return  (ArrayList<SendNameRateScaleAbbrev>) Arrays.stream(jsons).collect(Collectors.toList());


    }
    public ArrayList<SendNameRateScaleAbbrevDate> getJsonsArray3(String url) {

        SendNameRateScaleAbbrevDate[] jsons = new SendNameRateScaleAbbrevDate[0];

        RestTemplate restTemplate=proxyConfig.restTemplateWithoutProxy();

        jsons=restTemplate.getForObject(url,jsons.getClass());
        ArrayList<SendNameRateScaleAbbrevDate> JsonArray = (ArrayList<SendNameRateScaleAbbrevDate>) Arrays.stream(jsons).collect(Collectors.toList());


        return JsonArray ;

    }


}
