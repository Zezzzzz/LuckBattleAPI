package com.LuckBattle.Webservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@IdClass(UserLuck.class)
@AllArgsConstructor
@NoArgsConstructor
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
