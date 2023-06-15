package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


@Controller
public class HtmlController {
    @GetMapping("/")
    public String newprod(@RequestParam( required = false,defaultValue = "start") String Type) {
        if(Type.equals("period") ) return "Period";
        else return "Date";
    }

    @PostMapping("/generateUrl")
    public String createCredit(@RequestParam String infType,@RequestParam(required = false ,defaultValue = "-1") String startDate,@RequestParam(required = false ,defaultValue = "-1") String endDate,@RequestParam(required = false ,defaultValue = "-1") String date, Principal principal) {

    StringBuilder url=new StringBuilder();
    if (infType.equals("complete")){url.append("all");}
        url.append("rates");
        if (date.equals("-1"))
        {
            url.append("period?startperiod=");
            url.append(startDate);
            url.append("&endperiod=");
            url.append(endDate);
        }else
        {
            url.append("?date=");
            url.append(date);
        }

        return "redirect:/"+url;
    }
}
