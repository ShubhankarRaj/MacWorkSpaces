package com.learn.spring.tpoint;

import java.util.Date;

public class Answer {
    private int answerId;
    private String answerValue;
    private Date postedDate;

    public Answer(int answerId, String answerValue, Date postedDate) {
        this.answerId = answerId;
        this.answerValue = answerValue;
        this.postedDate = postedDate;
    }

    public String toString(){
        return "AnsID~"+answerId+" Answer: "+answerValue+" Posted On- "+postedDate;
    }
}
