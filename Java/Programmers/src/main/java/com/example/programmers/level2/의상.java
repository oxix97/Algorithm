package com.example.programmers.level2;

import java.util.*;

public class 의상 {
    public static void main(String[] args) {
        String[][] test1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] test2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(test1));
        System.out.println(solution(test2));
    }


    public static int solution(String[][] clothes) {
        //1. 해시맵 생성 String,Integer -> key : 종류, value : 옷 개수
        //2. 각 옷 종류 0/1/.../n개 입는 경우에 answer *= n + 1
        //3. 최소 1개의 옷은 입어야 하기 때문에 -1를 해준다.

        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 1) + 1);
        }

        Iterator<Integer> it = map.values().iterator();
        int answer = 1;
        while (it.hasNext()) {
            answer *= it.next();
        }

        return answer - 1;
    }
}
