package com.example.demo.Entity.Dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CurrencyDto {

    @JsonSetter("Cur_ID")
    private int Cur_ID;
    @JsonSetter("Cur_ParentID")
    private int Cur_ParentID;
    @JsonSetter("Cur_Code")
    private int Cur_Code;
    @JsonSetter("Cur_Abbreviation")
    private String Cur_Abbreviation;
    @JsonSetter("Cur_Name")
    private String Cur_Name;
    @JsonSetter("Cur_Name_Bel")
    private String Cur_Name_Bel;
    @JsonSetter("Cur_Name_Eng")
    private String Cur_Name_Eng;
    @JsonSetter("Cur_QuotName")
    private String Cur_QuotName;
    @JsonSetter("Cur_QuotName_Bel")
    private String Cur_QuotName_Bel;
    @JsonSetter("Cur_QuotName_Eng")
    private String Cur_QuotName_Eng;
    @JsonSetter("Cur_NameMulti")
    private String Cur_NameMulti;
    @JsonSetter("Cur_Name_BelMulti")
    private String Cur_Name_BelMulti;
    @JsonSetter("Cur_Name_EngMulti")
    private String Cur_Name_EngMulti;
    @JsonSetter("Cur_Scale")
    private int Cur_Scale;
    @JsonSetter("Cur_Periodicity")
    private int Cur_Periodicity;
    @JsonSetter("Cur_DateStart")
    private Date Cur_DateStart;
    @JsonSetter("Cur_DateEnd")
    private Date Cur_DateEnd;

}
