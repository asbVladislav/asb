package com.example.demo.Repository;

import com.example.demo.Entity.Rates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatesRepository extends CrudRepository<Rates,Integer> {
//    @Query(value = "select * from rate where id=:cur_id", nativeQuery = true)
//    List<Rates> findByCur_ID(@Param("cur_id")int id);
}
