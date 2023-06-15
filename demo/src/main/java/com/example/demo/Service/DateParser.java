package com.example.demo.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParser {
    private SimpleDateFormat simpleDateFormat;

    public DateParser(String simpleDateFormatString) {
        this.simpleDateFormat = new SimpleDateFormat(simpleDateFormatString);
    }

    public Date parse(String stringDate) throws ParseException {
        java.util.Date utilDate=simpleDateFormat.parse(stringDate);
        Date sqlDate=new Date(utilDate.getTime());
        return sqlDate;
    }
}
