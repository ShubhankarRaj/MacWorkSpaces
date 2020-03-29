package com.learn.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolWordLadder {
    public static class Node{
        String word;
        List<Node> neighbours;

        public Node(String word){
            this.word = word;
            neighbours = new ArrayList<>();
        }
    }

    public int ladderLen(String startWord, String endWord, ArrayList<String> dict){
        Map<String, Node> words = new HashMap<>();

        //  Adding all the words from the Dictionary array into a Hashmap
        //  This is done for probably faster access, and search by word and not by index
        for(String s : dict){
            words.put(s, new Node(s));
        }

        //  Finding all the neighbours of each word and updating the neighbour list in the Hashmap
        /*for()*/

        return 0;
    }
}
