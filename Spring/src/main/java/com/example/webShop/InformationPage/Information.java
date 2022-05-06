package com.example.webShop.InformationPage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "information")
@Getter
@Setter
@NoArgsConstructor
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String history;
    private String rules;
    private String equipment;

}
