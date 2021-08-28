import java.util.*;

public class level2_배달 {
    static int[][] map;
    static boolean[] visited;
    public static int solution(int N, int[][] road, int K) {
        Arrays.sort(road, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int target = 1;
        for (int i = 0; i < road.length; i++) {
            for (int j = 0; j < road[i].length; j++) {
                if (target == 1) {
                    if (road[j][0] == target && road[j][2] <= K) {
                        ++answer;
                        map.put(road[i][1], road[i][2]);
                    }
                } else {

                }
            }
            ++target;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int result = solution(5, road, 3);

        Arrays.sort(road, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < road.length; i++) {
            for (int j : road[i]) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void bfs(int point) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(point);

    }
}
