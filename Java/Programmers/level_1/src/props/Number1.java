package props;

import java.util.*;

public class Number1 {
    public static String[] solution(String[] param0) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        String[] answer = {};
        for (int i = 0; i < param0.length; i++) {
            String[] temp = param0[i].split("/");
            String str = temp[temp.length - 1];
            char first = str.charAt(0);
            String last = str.substring(str.length() - 2);
            String ans = first + last;
            list.add(ans);
        }
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            for (int j = 0; j < list.size(); j++) {

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] prop = {"/a/a_v2.x", "/b/a.x", "/d/a/t.x", "/e/z/t_v1.z", "/k/k/k/a_v9.x"};
        for (String s : prop) {
            String[] temp = s.split("/");
            String str = temp[temp.length - 1];
            char first = str.charAt(0);
            String last = str.substring(str.length() - 2);
            String ans = first + last;
            System.out.println(ans);
        }
    }
}
