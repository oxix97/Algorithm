import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 통계학_2108 {
    static int T;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        arr = new int[T];

        double sum = 0;
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        HashSet<Integer> set = new HashSet<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        double avg = sum / T;
        sb.append(Math.round(avg)).append('\n');
        Arrays.sort(arr);
        sb.append(arr[T / 2]).append('\n');

        ArrayList<Integer> list = new ArrayList<>(set);

        Prob[] cnt = new Prob[list.size()];

        for (int i = 0; i < cnt.length; i++) {
            cnt[i] = new Prob(list.get(i), 0);
        }
        for (int i : arr) {
            int idx = list.indexOf(i);
            ++cnt[idx].cnt;
        }

        Arrays.sort(cnt, new Comparator<Prob>() {
            @Override
            public int compare(Prob t1, Prob t2) {
                return t1.value - t2.value;
            }
        });
        Arrays.sort(cnt, new Comparator<Prob>() {
            @Override
            public int compare(Prob t1, Prob t2) {
                return t2.cnt - t1.cnt;
            }
        });

        if (arr.length > 1 && cnt[0].cnt == cnt[1].cnt) {
            sb.append(cnt[1].value).append('\n');
        } else {
            sb.append(cnt[0].value).append('\n');
        }

        if (T == 1) {
            sb.append(0).append('\n');
        } else {
            sb.append(arr[arr.length - 1] - arr[0]).append('\n');
        }
        System.out.println(sb);
    }

    static class Prob {
        int value;
        int cnt;

        public Prob(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }
}


