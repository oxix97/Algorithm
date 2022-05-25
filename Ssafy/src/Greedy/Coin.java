package Greedy;

import Util.UtilClass;

import java.util.ArrayList;

public class Coin {
    public static void main(String[] args) {
        UtilClass util = new UtilClass();
        ArrayList<Integer> list = util.inputCoinList();
        int totalCnt = 0;
        int coinNum = 0;
        int price = 4720;

        for (int i = 0; i < list.size(); i++) {
            coinNum = price / list.get(i);
            totalCnt += coinNum;
            price -= coinNum * list.get(i);
        }
        System.out.println(totalCnt);
    }

}
