package Recursion;

public class SearchFunction {
    public static void main(String[] args) {
        String[] arr = {"hi","Hello","World","Lee","Chan"};
        System.out.println(BinarySearch(arr,"Lee",0,6));
    }

    public static int BinarySearch(String[] arr, String target, int begin, int end) {
        if (begin > end) {
            return -1;
        } else {
            int mid = (begin + end) / 2;
            int result = target.compareTo(arr[mid]);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                return BinarySearch(arr, target, begin, mid - 1);
            } else {
                return BinarySearch(arr, target, mid + 1, end);
            }
        }
    }

    public static int search(int[] arr, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        } else if (target == arr[begin]) {
            return begin;
        } else {
            return search(arr, begin + 1, end, target);
        }
    }

    public static int search(int[] arr, int n, int target) {
        for (int i = 0; i < n; i++) {
            if(arr[i] == target) return i;
        }
        return -1;
    }

}
