package com.example.demo.Repository;

import com.example.demo.Entity.Rates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface RatesRepository extends CrudRepository<Rates,Integer> {
    @Query(value = "select * from rate where date =:dateFromUrl", nativeQuery = true)
    Rates[] findByDate(@Param("dateFromUrl") Date date);
    @Query(value = "select * from rate where date>=:startPeriodFromUrl and date <=:endPeriodFromUrl", nativeQuery = true)
    Rates[] findByPeriod(@Param("startPeriodFromUrl") Date start,@Param("endPeriodFromUrl")Date end);


}
