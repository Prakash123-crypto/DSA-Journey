package Practice

-Problems.Arrays.SubArrays;

public class MaxSizeSubArrOfSizeK {

    //brute force O((n-k)k) which is O(nk - k*2)
    public static int maxSumofK1(int[] arr, int k) {
        int n = arr.length;

        int maxSum = 0;

        for (int i = 0; i < n - k; i++) {
            int sum = 0;
            for (int j = i; j < k + i; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    //optimal TC -> O(n)
    public static int maxSumOfK2(int[] arr, int k) {
        int n = arr.length;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;

        for (int i = k; i < n; i++) {
            windowSum += arr[i];
            windowSum -= arr[i - k];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maxSumOfK2(arr, k));
    }
}
