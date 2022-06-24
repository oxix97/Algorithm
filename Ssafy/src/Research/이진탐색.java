package Research;

import Util.UtilClass;

import java.util.Arrays;

public class 이진탐색 {
    public static void main(String[] args) {
        UtilClass util = new UtilClass();
        int[] arr = new int[100];
        int target = 47;
        util.inputRandomValue(arr);
        Arrays.sort(arr);
        binarySearch(arr, target, 0, arr.length - 1);
    }

    private static void binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            System.out.println("none");
            return;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            System.out.println("target : " + arr[mid] + ", index : " + mid);
            return;
        } else if (target > arr[mid]) {
            binarySearch(arr, target, mid + 1, end);
        } else if (target < arr[mid]) {
            binarySearch(arr, target, start, mid - 1);
        }

        System.out.println(arr[mid]);
    }
}
