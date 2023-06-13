package com.example.demo.Service;

import com.example.demo.Configure.ProxyConfig;
import com.example.demo.Entity.Dto.RatesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
@Service
public class GetArrayListRatesDto {
    @Autowired
    public ProxyConfig proxyConfig;

    public ArrayList<RatesDto> getJsonsArray(String url) {

        RatesDto[] jsons = new RatesDto[0];

        RestTemplate restTemplate=proxyConfig.restTemplate();

        jsons=restTemplate.getForObject(url,jsons.getClass());
        ArrayList<RatesDto> JsonArray = (ArrayList<RatesDto>) Arrays.stream(jsons).collect(Collectors.toList());


        return JsonArray ;

    }

}
