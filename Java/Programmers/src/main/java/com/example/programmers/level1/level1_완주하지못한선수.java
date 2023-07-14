package com.example.programmers.level1;

import java.util.*;
public class level1_완주하지못한선수 {
    static String solution(String[] participant, String[] completion){
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i=0;i<completion.length;i++)
            if(!participant[i].equals(completion[i]))
                return participant[i];
        return participant[i];
    }
    public static void main(String[] args) {
        String[] participant = {"leo","kiki","eden"};
        String[] completion = {"eden","kiki"};

        String result = solution(participant,completion);
        System.out.println(result);
    }

}
