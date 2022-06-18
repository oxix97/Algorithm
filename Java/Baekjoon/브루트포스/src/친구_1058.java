import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 친구_1058 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            String tmp = br.readLine();

            for (int j = 0; j < N; j++) {
                if (tmp.charAt(j) == 'Y') {
                    list.add(j + 1);
                }
            }
            map.put(i, list);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> list = map.get(i);
            ArrayList<Integer> emptyList = new ArrayList<>(list);
            for (int item : list) {
                ArrayList<Integer> tmp = map.get(item);
                emptyList.addAll(tmp);
            }
            HashSet<Integer> set = new HashSet<>(emptyList);
            ArrayList<Integer> friendList = new ArrayList<>(set);
            cnt = Math.max(cnt, friendList.size());
        }
        if (cnt != 0) --cnt;
        System.out.println(cnt);
    }
}
