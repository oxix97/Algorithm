import java.util.ArrayList;

public class level1_로또최고순위와최저순위 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : win_nums) list.add(i);
        int count = 7;
        int max = 0;
        int min = 0;
        for (int i : lottos) {
            if (list.contains(i)) {
                ++max;
                ++min;
            } else if (i == 0) {
                max += 1;
            }
            System.out.println(i);
        }
        if (min == 0) min = 1;
        if (max == 0) max = 1;

        return new int[]{count - max, count - min};
    }

    public static void main(String[] args) {
//        int[] lottos1 = {44, 1, 0, 0, 31, 25};
//        int[] lottos2 = {0, 0, 0, 0, 0, 0};
//        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] lottos4 = {1, 2, 3, 4, 5, 6};
//        int[] win_nums1 = {31, 10, 45, 1, 6, 19};
//        int[] win_nums2 = {38, 19, 20, 40, 15, 25};
//        int[] win_nums3 = {20, 9, 3, 45, 4, 35};
        int[] win_nums4 = {41, 42, 7, 8, 9, 10};
//        int[] ans1 = solution(lottos1, win_nums1);
//        int[] ans2 = solution(lottos2, win_nums2);
//        int[] ans3 = solution(lottos3, win_nums3);
        int[] ans4 = solution(lottos4, win_nums4);
        for (int i : ans4) System.out.print(i + " ");
    }
}
