package com.example.demo.Entity.Dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class RatesDto {

    @JsonSetter("Cur_ID")
    private int Cur_ID;
    @JsonSetter("Cur_Name")
    private String Cur_Name;
    @JsonSetter("Cur_OfficialRate")
    private double Cur_OfficialRate;
    @JsonSetter("Cur_Abbreviation")
    private String Cur_Abbreviation;
    @JsonSetter("Date")
    private java.sql.Date Date;


    @JsonSetter("Cur_Scale")
    private int Cur_Scale;
}
