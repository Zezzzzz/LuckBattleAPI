package com.LuckBattle.Webservices.repository;

import com.LuckBattle.Webservices.entity.MaxLuck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface MaxLuckRepository extends JpaRepository<MaxLuck, Date> {

    @Query("select m from MaxLuck m where m.date = :date")
    Optional<MaxLuck> findByMaxLuckByDate(@Param("date") Date date);

//    @Query("UPDATE MaxLuck set max_luck = :max_luck where date == :date")
//    void setMaxLuckOfDate(@Param("date") Date date, @Param("max_luck") double max_luck);
}
