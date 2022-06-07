package com.LuckBattle.Webservices.service;

import com.LuckBattle.Webservices.entity.MaxLuck;
import com.LuckBattle.Webservices.entity.MinLuck;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface LuckService {
    // Save operation
    @Transactional
    MaxLuck saveMaxLuck(MaxLuck maxLuck);

    @Transactional
    MinLuck saveMinLuck(MinLuck minLuck);

    @Transactional
    MaxLuck fetchMaxLuck(java.sql.Date date);

    @Transactional
    MinLuck fetchMinLuck(Date date);

    List<MaxLuck> fetchMaxLuckList();

    List<MinLuck> fetchMinLuckList();
    // Update operation
    boolean updateMaxLuck(Date date, double maxLuck);

    // Delete operation
    void deleteMaxLuckByDate(Date date);

}
