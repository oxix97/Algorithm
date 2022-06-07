import java.util.*;

public class 성적이낮은순서로학생출력 {
    static Scanner sc = new Scanner(System.in);
    static int T;

    static class Grade implements Comparable<Grade> {
        String name = "";
        int point = 0;

        public Grade(String name, int point) {
            this.name = name;
            this.point = point;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public int compareTo(Grade grade) {
            return this.point - grade.point;
        }
    }

    public static void main(String[] args) {
        T = sc.nextInt();
        ArrayList<Grade> list = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            String name = sc.next();
            int point = sc.nextInt();
            list.add(new Grade(name, point));
        }

        Collections.sort(list);

        for (Grade g : list) {
            System.out.print(g+" ");
        }
    }
}
