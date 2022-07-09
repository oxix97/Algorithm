import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 덱_10866 {
    static int N;
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String[] command = br.readLine().split(" ");
            String[] str = command[0].split("_");
            if (command.length == 2) {
                //push
                if (str[1].equals("back")) {
                    deque.offerLast(Integer.parseInt(command[1]));
                } else {
                    deque.offerFirst(Integer.parseInt(command[1]));
                }
            } else {
                if (str.length == 2) {
                    if (str[1].equals("front")) {
                        funRemove("front");
                    } else {
                        funRemove("back");
                    }
                } else {
                    switch (command[0]) {
                        case "empty": {
                            funEmpty();
                            break;
                        }
                        case "size":
                            System.out.println(deque.size());
                            break;
                        case "front":
                            funGet("front");
                            break;
                        case "back":
                            funGet("back");
                            break;
                    }
                }
            }
        }
    }

    private static void funGet(String str) {
        if (deque.size() == 0) {
            System.out.println(-1);
            return;
        }
        if (str.equals("front")) {
            System.out.println(deque.getFirst());
        } else {
            System.out.println(deque.getLast());
        }
    }


    private static void funEmpty() {
        if (deque.size() == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void funRemove(String c) {
        if (deque.size() == 0) {
            System.out.println(-1);
            return;
        }

        if (c.equals("front")) {
            System.out.println(deque.removeFirst());
        } else {
            System.out.println(deque.removeLast());
        }
    }
}
