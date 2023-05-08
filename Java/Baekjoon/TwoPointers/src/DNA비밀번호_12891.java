import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호_12891 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산 2초
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int S, P; //S : 임의로 만든 dna길이, P : 추출할 비밀번호 길이  / 1…P…S…1,000,000
    static char[] DNA; // 임의로 입력 받은 dna
    static int[] ACGT; // 비밀번호에 생성 요구사항 저장
    static int[] state;
    static int answer;

    public static void main(String[] args) throws IOException {
        inputs(); // 입력값 받기
        solution();
        output();
        br.close();
    }

    private static void solution() {
        initialSubArr();   //1. 초기 슬라이싱 배열 만들고 검사
        slicingArr();      //2. 앞뒤로 한개씩만 더하고 뺀다. P>S 종료
    }

    private static void slicingArr() {
        for (int R = P; R < S; R++) {
            int L = R - P;
            addDNA(DNA[R]);
            removeDNA(DNA[L]);
            if (isSuccess())
                ++answer;
        }
    }

    private static void removeDNA(char c) {
        int idx = findDNA(c);
        state[idx]--;
    }

    private static int findDNA(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return -1;
    }

    private static void initialSubArr() {
        state = new int[4];
        for (int i = 0; i < P; i++) {
            addDNA(DNA[i]);
        }
        if (isSuccess()) ++answer;
    }

    private static boolean isSuccess() {
        for (int i = 0; i < 4; i++) {
            if (state[i] < ACGT[i])
                return false;
        }
        return true;
    }

    private static void addDNA(char c) {
        int idx = findDNA(c);
        state[idx]++;
    }

    private static void output() {
        System.out.println(answer);
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        DNA = br.readLine().toCharArray();
        ACGT = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ACGT[i] = Integer.parseInt(st.nextToken());
        }
    }
}
