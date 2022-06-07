package com.LuckBattle.Webservices.service;

import com.LuckBattle.Webservices.entity.UserLuck;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface UserLuckService {
    // Save operation
    @Transactional
    UserLuck saveLuck(UserLuck luck);

    @Transactional
    Optional<UserLuck> fetchLuckByDateAndUserId(Date date, int user_id);

    @Transactional
    Optional<UserLuck> fetchLuckByUserId(int user_id);

    // Read operation
    List<UserLuck> fetchLuckList();

    // Update operation
    boolean updateLuck(Date date, double luck);

    // Delete operation
    void deleteLuckByDate(Date date);
}
