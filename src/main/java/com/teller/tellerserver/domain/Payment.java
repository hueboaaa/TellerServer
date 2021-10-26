package com.teller.tellerserver.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "pay_id")
    private String id;
    private String bank_name;

}
