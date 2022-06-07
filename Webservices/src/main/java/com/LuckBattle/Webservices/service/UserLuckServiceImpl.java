package com.LuckBattle.Webservices.service;

import com.LuckBattle.Webservices.entity.UserLuck;
import com.LuckBattle.Webservices.repository.UserLuckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserLuckServiceImpl implements UserLuckService{

    @Autowired
    private UserLuckRepository userLuckRepository;

    @Override
    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public UserLuck saveLuck(UserLuck userLuck) {
        return userLuckRepository.saveAndFlush(userLuck);
    }

    @Override
    public Optional<UserLuck> fetchLuckByDateAndUserId(Date date, int user_id) {
        return userLuckRepository.findUserLuckByUserIdAndDate(user_id,date);
    }

    @Override
    public Optional<UserLuck> fetchLuckByUserId(int user_id) {
        return userLuckRepository.findUserLuckByUserId(user_id);
    }

    @Override
    public List<UserLuck> fetchLuckList() {
        return null;
    }

    @Override
    public boolean updateLuck(Date date, double luck) {
        return false;
    }

    @Override
    public void deleteLuckByDate(Date date) {

    }
}
