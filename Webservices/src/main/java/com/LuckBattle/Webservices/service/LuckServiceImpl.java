package com.LuckBattle.Webservices.service;

import com.LuckBattle.Webservices.entity.MaxLuck;
import com.LuckBattle.Webservices.entity.MinLuck;
import com.LuckBattle.Webservices.repository.MaxLuckRepository;
import com.LuckBattle.Webservices.repository.MinLuckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class LuckServiceImpl implements LuckService{

    @Autowired
    private MaxLuckRepository maxLuckRepository;

    @Autowired
    private MinLuckRepository minLuckRepository;

    @Override
    @Transactional
    public MaxLuck saveMaxLuck(MaxLuck maxLuck) {
        return maxLuckRepository.saveAndFlush(maxLuck);
    }

    @Override
    public MinLuck saveMinLuck(MinLuck minLuck) {
        return minLuckRepository.saveAndFlush(minLuck);
    }

    @Override
    @Transactional
    public MaxLuck fetchMaxLuck(Date date){
        return maxLuckRepository.findByMaxLuckByDate(date).orElse(null);
    }

    @Override
    public MinLuck fetchMinLuck(Date date) {
        return minLuckRepository.findByMinLuckByDate(date).orElse(null);
    }

    @Override
    public List<MaxLuck> fetchMaxLuckList() {
        return (List<MaxLuck>) maxLuckRepository.findAll();
    }

    @Override
    public List<MinLuck> fetchMinLuckList() {
        return (List<MinLuck>) minLuckRepository.findAll();
    }

    @Override
    public boolean updateMaxLuck(Date date, double max_Luck) {
        try {
//            maxLuckRepository.setMaxLuckOfDate(date, max_Luck);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void deleteMaxLuckByDate(Date date) {

    }

}
