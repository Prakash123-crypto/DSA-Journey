package Practice

-Problems.Arrays.SubArrays;

public class MaxConsecutiveOnes {

    public static int maxOnes1(int[] arr) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 1) {
                    cnt++;
                    maxLen = Math.max(maxLen, cnt);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static int maxOnes2(int[] arr) {
        int n = arr.length;

        int cnt = 0;
        int maxLen = 0;
        for (int i : arr) {
            if (i == 1) {
                cnt++;
                maxLen = Math.max(maxLen, cnt);
            } else {
                cnt = 0;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 1, 1};
        System.out.println(maxOnes1(arr));
    }
}
