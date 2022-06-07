package com.LuckBattle.Webservices.controller;

import com.LuckBattle.Webservices.entity.MaxLuck;
import com.LuckBattle.Webservices.entity.MinLuck;
import com.LuckBattle.Webservices.entity.UserLuck;
import com.LuckBattle.Webservices.service.LuckService;
import com.LuckBattle.Webservices.service.UserLuckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping(path="/luck")
public class LuckController {
    @Autowired
    private LuckService luckService;

    @Autowired
    private UserLuckService userLuckService;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock writeLockMaxLuck = lock.writeLock();
    private final Lock writeLockMinLuck = lock.writeLock();
    private TimeUnit unit = TimeUnit.MILLISECONDS;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity<UserLuck> GenerateUserLuck (@RequestParam String date
            , @RequestParam String id) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date d = simpleDateFormat.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(d.getTime());
            Random rand = new Random();
            double luck = rand.nextGaussian() * 1000;
            int user_id = Integer.parseInt(id);
            if(userLuckService.fetchLuckByDateAndUserId(sqlDate,user_id).orElse(null) != null) {
                return ResponseEntity.badRequest().body(null);
            } else{
                writeLockMaxLuck.lock();
                try {
                    double maxLuck = luckService.fetchMaxLuck(sqlDate) == null? luck:luckService.fetchMaxLuck(sqlDate).getMax_luck();
                    double minLuck = luckService.fetchMinLuck(sqlDate) == null? luck:luckService.fetchMinLuck(sqlDate).getMin_luck();
                    if(maxLuck <= luck) {
                        luckService.saveMaxLuck(new MaxLuck(sqlDate, luck));
                    }
                    if(minLuck >= luck){
                        luckService.saveMinLuck(new MinLuck(sqlDate, luck));
                    }
                    return ResponseEntity.status(HttpStatus.OK).body(userLuckService.saveLuck(new UserLuck(user_id,sqlDate,luck)));
                }  catch (NumberFormatException e) {
                    e.printStackTrace();
                    return ResponseEntity.badRequest().body(null);
                } finally {
                    writeLockMaxLuck.unlock();
                }

            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(path="/maxLuckForDate")
    public @ResponseBody MaxLuck maxLuckForDate (@RequestParam String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date d = simpleDateFormat.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(d.getTime());
            return luckService.fetchMaxLuck(sqlDate);
        } catch (Exception e){
            return null;
        }
    }

    @GetMapping("/allLuck")
    public @ResponseBody Iterable<MaxLuck> getAllMaxLuck() {
        return luckService.fetchMaxLuckList();
    }
}
