package com.LuckBattle.Webservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@IdClass(UserLuck.class)
@AllArgsConstructor
public class UserLuck implements Serializable {

    @Id
    @Column(name = "user_id")
    private int user_id;
    @Id
    @NonNull
    @Column(name = "date")
    private Date date;
    @Column(name = "luck")
    private double luck;
}
