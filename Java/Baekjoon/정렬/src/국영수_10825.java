import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 국영수_10825 {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Grade[] list;
    static int N;

    static class Grade implements Comparable<Grade> {
        String name;
        int korean;
        int english;
        int math;

        public Grade(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Grade grade) {
            if (this.korean == grade.korean) {
                if (this.english == grade.english) {
                    if (grade.math == this.math) {
                        return this.name.compareTo(grade.name);
                    } else {
                        return grade.math - this.math;
                    }
                } else {
                    return this.english - grade.english;
                }
            } else {
                return grade.korean - this.korean;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(list);
        output();
    }

    private static void output() {
        for (Grade item : list) {
            sb.append(item.name).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new Grade[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list[i] = new Grade(name, korean, english, math);
        }
    }
}
