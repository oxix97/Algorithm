package src.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17413 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        //1. 각 입력값들의 파라미터 정리
        //2. 시간복잡도, 공간복잡도 계산
        //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
        //4. 단계별로 sudo 코드 작성
        //5. 구현
        //6. 오류 발생시 디버그를 활용하거나 자료형 확인
        boolean check = false;
        StringBuilder answer = new StringBuilder();
        for (char c : br.readLine().toCharArray()) {
            if (!check) {
                if (c == ' ') {
                    answer.append(sb.reverse()).append(' ');
                    sb = new StringBuilder();
                } else {
                    if (c == '<') {
                        check = true;
                        answer.append(sb.reverse());
                        sb = new StringBuilder();
                    }
                    sb.append(c);
                }
            } else {
                sb.append(c);
                if (c == '>') {
                    check = false;
                    answer.append(sb);
                    sb = new StringBuilder();
                }
            }
        }

        answer.append(sb.reverse());
        System.out.println(answer);
        br.close();
    }
}
