package com.example.demo.Entity.Sends;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class SendNameRateScaleAbbrev {
    public SendNameRateScaleAbbrev(String cur_Name, double cur_OfficialRate, String cur_Abbreviation, int cur_Scale) {
        Cur_Name = cur_Name;
        Cur_OfficialRate = cur_OfficialRate;
        Cur_Abbreviation = cur_Abbreviation;
        Cur_Scale = cur_Scale;
    }
@Id
    private String Cur_Name;
    private double Cur_OfficialRate;
    private String Cur_Abbreviation;
    private int Cur_Scale;



}
