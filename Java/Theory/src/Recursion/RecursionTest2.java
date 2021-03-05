package Recursion;

public class RecursionTest2 {

    public static void main(String[] args) {

    }

    public static int sum(int n, int[] arr) {
        if (n == 0) {
            return 0;
        } else {
            return sum(n - 1, arr) + arr[n - 1];
        }
    }

    public static void printInBinary(int n) {
        if (n < 2) {
            System.out.print(n);
        } else {
            printInBinary(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void printCharsReverse(String str) {
        if (str.length() == 0) {
            System.out.println("finish");
            return;
        } else {
            printCharsReverse(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    public static void printChars(String str) {
        if (str.length() == 0) {
            return;
        } else {
            System.out.println(str.charAt(0) + " ");
            printChars(str.substring(1));
        }
    }

    public static int length(String str) {
        if(str.equals("")) return 0;
        else return 1 + length(str.substring(1));
    }
}
