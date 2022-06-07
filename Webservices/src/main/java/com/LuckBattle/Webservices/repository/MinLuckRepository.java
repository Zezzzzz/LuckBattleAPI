package com.LuckBattle.Webservices.repository;

import com.LuckBattle.Webservices.entity.MinLuck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface MinLuckRepository extends JpaRepository<MinLuck, Date> {

    @Query("select m from MinLuck m where m.date = :date")
    Optional<MinLuck> findByMinLuckByDate(@Param("date") Date date);
}
