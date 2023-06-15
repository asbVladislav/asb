package com.example.demo.Entity;





import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table( name="Rate")
public class Rates {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int ID;



    @Column(name = "Cur_ID", nullable = false)
    //@ManyToOne
    private int Cur_ID;
    private String Cur_Name;
    private double Cur_OfficialRate;
    private String Cur_Abbreviation;
    private Date Date;
    private int Cur_Scale;

//    public Rates getFirstResponse(Rates requestRate) {
//        Rates responseRate=new Rates();
//        responseRate.setCur_ID(requestRate.getCur_ID());
//        return responseRate;
//    }

    public Rates(int cur_ID, String cur_Name, double cur_OfficialRate, String cur_Abbreviation, java.sql.Date date, int cur_Scale) {
        Cur_ID = cur_ID;
        Cur_Name = cur_Name;
        Cur_OfficialRate = cur_OfficialRate;
        Cur_Abbreviation = cur_Abbreviation;
        Date = date;
        Cur_Scale = cur_Scale;
    }
}
