package com.example.demo.Repository;

import com.example.demo.Entity.Currency;
import com.example.demo.Entity.Rates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurrencyRepository extends CrudRepository<Currency,Integer> {
        @Query(value = "select * from currency where Cur_ID=:cur_id", nativeQuery = true)
       Currency findByCur_ID(@Param("cur_id")int id);
}
