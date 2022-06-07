package com.LuckBattle.Webservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
public class MaxLuck {
    @NonNull
    @Id
    private Date date;
    private double max_luck;
}
