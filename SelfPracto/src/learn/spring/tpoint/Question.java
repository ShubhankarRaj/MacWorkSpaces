package com.learn.spring.tpoint;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question {
    private int id;
    private String question;
    private List<Answer> answers;
    private Map<Answer, User> answersUsersMap;

    public Question(int id, String question, List<Answer> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    public Question(int id, String question, Map<Answer, User> answersUsersMap) {
        this.id = id;
        this.question = question;
        this.answersUsersMap = answersUsersMap;
    }


    public void displayInfo(){
        /*System.out.println(id+", "+question);
        System.out.println("Answers are:");
        Iterator<Answer> itr = answers.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }*/

        System.out.println("Printing the Answers and Users from the MAP");
        System.out.println("Question ID: "+id);
        System.out.println("QUESTION: "+question);
        System.out.println("Answers....");
        Set<Map.Entry<Answer, User>> set = answersUsersMap.entrySet();
        Iterator<Map.Entry<Answer, User>> itr1 = set.iterator();
        while (itr1.hasNext()){
            Map.Entry<Answer, User> entry = itr1.next();
            Answer ans = entry.getKey();
            User usr = entry.getValue();
            System.out.println("Comments: "+ans);
            System.out.println("Posted By: "+usr);
            System.out.println();
        }
    }
}
