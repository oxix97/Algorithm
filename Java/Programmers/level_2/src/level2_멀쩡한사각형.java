import java.util.*;
public class level2_멀쩡한사각형 {
    public static long solution(long w,long h) {
        long n = w<h ? w:h;
        long max = 0;
        for(long i=1; i<=n;i++)
            if(w%i==0 && h%i==0)
                max = i;
        return (w*h) - (w+h-max);
    }
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w,h));
    }
}
