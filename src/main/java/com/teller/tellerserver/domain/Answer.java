package com.teller.tellerserver.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    @Column(name = "answer_id")
    private Long id;

    private String ans_interest_cnt;
    private String ans_obj;
    private String ans_desc;
    private LocalDateTime ans_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
