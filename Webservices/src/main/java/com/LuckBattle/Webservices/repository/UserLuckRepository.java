package com.LuckBattle.Webservices.repository;

import com.LuckBattle.Webservices.entity.UserLuck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Optional;

public interface UserLuckRepository extends JpaRepository<UserLuck, Date> {

    @Query("select l from UserLuck l where l.user_id = :user_id")
    @Transactional
    Optional<UserLuck> findUserLuckByUserId(@Param("user_id") int user_id);

    @Query("select l from UserLuck l where user_id = :user_id and date = :date")
    @Transactional
    Optional<UserLuck> findUserLuckByUserIdAndDate(@Param("user_id") int user_id, @Param("date") Date date);
}
