package com.example.demo.Entity.Sends;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class SendAll {
    public SendAll(int cur_ID, int cur_ParentID, int cur_Code, String cur_Abbreviation, String cur_Name, String cur_Name_Bel, String cur_Name_Eng, String cur_QuotName, String cur_QuotName_Bel, String cur_QuotName_Eng, String cur_NameMulti, String cur_Name_BelMulti, String cur_Name_EngMulti, int cur_Scale, int cur_Periodicity, Date cur_DateStart, Date cur_DateEnd, double cur_OfficialRate) {
        Cur_ID = cur_ID;
        Cur_ParentID = cur_ParentID;
        Cur_Code = cur_Code;
        Cur_Abbreviation = cur_Abbreviation;
        Cur_Name = cur_Name;
        Cur_Name_Bel = cur_Name_Bel;
        Cur_Name_Eng = cur_Name_Eng;
        Cur_QuotName = cur_QuotName;
        Cur_QuotName_Bel = cur_QuotName_Bel;
        Cur_QuotName_Eng = cur_QuotName_Eng;
        Cur_NameMulti = cur_NameMulti;
        Cur_Name_BelMulti = cur_Name_BelMulti;
        Cur_Name_EngMulti = cur_Name_EngMulti;
        Cur_Scale = cur_Scale;
        Cur_Periodicity = cur_Periodicity;
        Cur_DateStart = cur_DateStart;
        Cur_DateEnd = cur_DateEnd;
        Cur_OfficialRate = cur_OfficialRate;
    }

    @Id
    private int Cur_ID;

    private int Cur_ParentID;
    private int Cur_Code;
    private String Cur_Abbreviation;
    private String Cur_Name;
    private String Cur_Name_Bel;
    private String Cur_Name_Eng;
    private String Cur_QuotName;
    private String Cur_QuotName_Bel;
    private String Cur_QuotName_Eng;
    private String Cur_NameMulti;
    private String Cur_Name_BelMulti;
    private String Cur_Name_EngMulti;
    private int Cur_Scale;
    private int Cur_Periodicity;
    private Date Cur_DateStart;
    private Date Cur_DateEnd;
    private double Cur_OfficialRate;



}
