package com.teller.tellerserver.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    @OneToMany(mappedBy = "question")
    private List<Answer> answer = new ArrayList<>();
}
