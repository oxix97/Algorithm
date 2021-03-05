package Recursion;

public class RecursionTest {
    public static void main(String[] args) {
        double result = gcd(7,5);
        int sr = sampleGcd(5,7);
        System.out.println(result);
        System.out.println(sr);

    }

    public static int sampleGcd(int p, int q) {
        if (q == 0) {
            return p;
        }else{
            return sampleGcd(q,p%q);
        }
    }

    public static double gcd(int m, int n) {
        int max = Math.max(m,n);
        int min = Math.min(m,n);
        if (max % min == 0) {
            return min;
        } else {
            return gcd(min, max % min);
        }
    }

    public static int fibonacci(int n) {
        if (n < 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x,n-1);
        }
    }

    public static int factorial (int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static int func2(int n){
        if (n <= 0) {
            return 0;
        }else{
            return n + func2(n-1);
        }
    }

    public static void func1(int n) {
        if (n <= 0) {
            return;
        } else {
            System.out.println("World!");
            func1(n-1);
        }
    }

}
