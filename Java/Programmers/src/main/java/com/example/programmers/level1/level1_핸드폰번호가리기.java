package com.example.programmers.level1;

import java.util.*;
import java.io.*;

public class level1_핸드폰번호가리기 {
    /*public static String solution(String phone_number){
        //무슨 말이지??
        return phone_number.replaceAll(".(?=.{4})","*");
    }
    */
    public static String solution(String phone_number) {
        return "*".repeat(phone_number.length()-4)+phone_number.substring(phone_number.length()-4);
    }

    public static void main(String[] args) {
        String s1 = "12222";
        String s2 = "023334444";
        String s3 = "01011112222";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));

    }
}
