package Research;

public class 순차탐색 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int value = 3;
        boolean isTrue = sequentialSearch(arr, value);
        System.out.println(isTrue);
    }

    private static boolean sequentialSearch(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) return true;
        }
        return false;
    }
}
