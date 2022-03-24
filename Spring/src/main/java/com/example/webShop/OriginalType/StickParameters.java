package com.example.webShop.OriginalType;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StickParameters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    double weightOfPlayer;
    double heightOfPlayer;

    double idealStickLong;
    double idealStickHardness;
    int idealBladeHardness;




}
