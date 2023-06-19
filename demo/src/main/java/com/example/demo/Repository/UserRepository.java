package com.example.demo.Repository;



import com.example.demo.Entity.Security.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    @Query(
            value = "select * from user",
            nativeQuery = true)
    ArrayList<User> findAllUsers();

    @Query(
            value = "select * from user where login=:log",
            nativeQuery = true)
    User findByLogin(@Param("log") String log);
//
//    @Query(
//            value = "select id from bank.user where login=:log",
//            nativeQuery = true)
//    Long findIdByLogin(@Param("log") String log);
//
//    @Query(
//            value = "select * from bank.user where ID=:IDprod",
//            nativeQuery = true)
//    User findIdByID(@Param("IDprod") long ID);
//    @Query(
//            value = "select login from bank.user ",
//            nativeQuery = true)
//    ArrayList<String> AllLogin();
//
//    @Query(
//            value = "select max(ID) from bank.user ",
//            nativeQuery = true)
//    Long maxId();

}
