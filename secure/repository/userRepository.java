package Vlad.IT.by.posts.repository;


import Vlad.IT.by.posts.models.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface userRepository extends CrudRepository<user,String> {

    @Query(
            value = "select * from bank.user where login=:log",
            nativeQuery = true)
    Optional<user> findByLogin(@Param("log") String log);

    @Query(
            value = "select * from bank.user where login=:log",
            nativeQuery = true)
    user findByLoginUS(@Param("log") String log);

    @Query(
            value = "select id from bank.user where login=:log",
            nativeQuery = true)
    Long findIdByLogin(@Param("log") String log);

    @Query(
            value = "select * from bank.user where ID=:IDprod",
            nativeQuery = true)
    user findIdByID(@Param("IDprod") long ID);
    @Query(
            value = "select login from bank.user ",
            nativeQuery = true)
    ArrayList<String> AllLogin();

    @Query(
            value = "select max(ID) from bank.user ",
            nativeQuery = true)
    Long maxId();

}
