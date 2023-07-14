package com.example.programmers.level1;

public class level1_음양더하기 {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < signs.length; i++) {
            if(signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] absolutes1 = {4,7,12};
        int[] absolutes2 = {1,2,3};
        boolean[] signs1 = {true,false,true};
        boolean[] signs2 = {false,false,true};

        System.out.println(solution(absolutes1,signs1));
        System.out.println(solution(absolutes2,signs2));
    }
}
