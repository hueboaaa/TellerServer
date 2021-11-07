package com.teller.tellerserver.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Interests {

    @Id
    @GeneratedValue
    @Column(name = "interest_id")
    private String id;
    private String interest ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
