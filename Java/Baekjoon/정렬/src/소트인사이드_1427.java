import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소트인사이드_1427 {
    //1. 각 입력값들의 파라미터 정리
    //2. 시간복잡도, 공간복잡도 계산
    //3. 올바른 풀이방법 설정 이후 부가적으로 필요한 파라미터가 있는지 체크
    //4. 단계별로 sudo 코드 작성
    //5. 구현
    //6. 오류 발생시 디버그를 활용하거나 자료형 확인
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
        br.close();
    }

    private static void solution() {
        for (int i = 0; i < nums.length; i++) {
            int max = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[max] < nums[j]) {
                    max = j;
                }
            }

            if (nums[max] > nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[max];
                nums[max] = tmp;
            }
        }
    }

    private static void output() {
        for (int n : nums) {
            sb.append(n);
        }
        System.out.println(sb);
    }

    private static void inputs() throws IOException {
        String input = br.readLine();
        nums = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            nums[i] = Integer.parseInt(input.substring(i, i + 1));
        }
    }
}
