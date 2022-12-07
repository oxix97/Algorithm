import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 물통_2251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] limitWater;
    static boolean[][][] visited;
    static boolean[] isPossible;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }

    private static void solution() {
        bfs(0, 0, limitWater[2]);

        for (int i = 0; i <= limitWater[2]; i++) {
            if (isPossible[i]) sb.append(i).append(' ');
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int a, int b, int c) {
        Queue<State> q = new LinkedList<>();
        visited[a][b][c] = true;
        q.add(new State(new int[]{a, b, c}));

        while (!q.isEmpty()) {
            State st = q.poll();
            if (st.nowState[0] == 0) isPossible[st.nowState[2]] = true;

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    State tmp = st.move(from, to, limitWater);

                    if (!visited[tmp.nowState[0]][tmp.nowState[1]][tmp.nowState[2]]) {
                        visited[tmp.nowState[0]][tmp.nowState[1]][tmp.nowState[2]] = true;
                        q.add(tmp);
                    }
                }
            }
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        limitWater = new int[3];
        for (int i = 0; i < 3; i++)
            limitWater[i] = Integer.parseInt(st.nextToken());

        isPossible = new boolean[limitWater[2] + 1];
        visited = new boolean[205][205][205];
    }

    static class State {
        int[] nowState;

        public State(int[] state) {
            nowState = new int[3];
            for (int i = 0; i < 3; i++)
                nowState[i] = state[i];
        }

        State move(int from, int to, int[] limit) {
            int[] state = new int[]{nowState[0], nowState[1], nowState[2]};

            if (state[from] + state[to] >= limit[to]) {
                state[from] -= (limit[to] - state[to]);
                state[to] = limit[to];
            } else {
                state[to] += state[from];
                state[from] = 0;
            }
            return new State(state);
        }
    }
}