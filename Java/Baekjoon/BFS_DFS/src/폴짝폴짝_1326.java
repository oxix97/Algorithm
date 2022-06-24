import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 폴짝폴짝_1326 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int[] target;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        arr = new int[N + 1];
        inputArr(arr, input1);
        String[] input2 = br.readLine().split(" ");
        target = new int[3];
        inputArr(target, input2);
        //input()

        bfs();

    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

    }

    private static void inputArr(int[] arr, String[] str) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
    }
}
