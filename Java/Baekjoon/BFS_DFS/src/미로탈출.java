import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탈출 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int M;
    static int[][] maze;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        input();
        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.x;
            y = node.y;

            for (int i = 0; i < 4; i++) {
                int tempX = x + dx[i];
                int tempY = y + dy[i];
                if (tempX < 0 || tempX >= N || tempY < 0 || tempY >= M) continue;
                if (maze[tempX][tempY] == 1) {
                    maze[tempX][tempY] = maze[x][y] + 1;
                    queue.add(new Node(tempX, tempY));
                }
            }
        }
    }

    private static void input() {
        for (int i = 0; i < N; i++) {
            String inputs = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(inputs.substring(j, j + 1));
            }
        }
    }


    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
