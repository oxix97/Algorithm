import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 큐_10845 {
    static int N;
    static ArrayList<Integer> queue = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("push")) {
                queue.add(Integer.parseInt(command[1]));
            } else {
//                System.out.print("command : " + command[0] + " ");
                switch (command[0]) {
                    case "empty":
                        funEmpty();
                        break;
                    case "pop":
                        funPop();
                        break;
                    case "size":
                        System.out.println(queue.size());
                        break;
                    case "front":
                        funFront();
                        break;
                    case "back":
                        funBack();
                        break;
                }
            }
        }
    }

    private static void funBack() {
        if (queue.size() == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(queue.get(queue.size() - 1));
    }

    private static void funFront() {
        if (queue.size() == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(queue.get(0));
    }

    private static void funPop() {
        if (queue.size() == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(queue.remove(0));
    }

    private static void funEmpty() {
        if (queue.size() == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}
