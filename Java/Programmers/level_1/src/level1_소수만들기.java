public class level1_소수만들기 {
    public static int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    temp = nums[i] + nums[j] + nums[k];
                    if (check(temp) == 0) ++answer;
                }
            }
        }
        return answer;
    }

    public static int check(int n) {
        int chk = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) ++chk;
        }
        return chk;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 7, 6, 4};

        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
    }
}
