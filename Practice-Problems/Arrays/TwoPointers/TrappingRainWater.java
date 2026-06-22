package Practice

-Problems.Arrays.TwoPointers;

public class TrappingRainWater {

    //brute force O(n*2) checking the leftmax and max with loops
    public static int trapWater1(int[] arr) {
        int n = arr.length;
        int water = 0;
        for (int i = 0; i < n; i++) {
            int leftmax = 0;
            for (int j = 0; j <= i; j++) {
                leftmax = Math.max(leftmax, arr[j]);
            }
            int rightmax = 0;
            for (int j = i; j < n; j++) {
                rightmax = Math.max(rightmax, arr[j]);
            }
            water += Math.min(leftmax, rightmax) - arr[i];
        }
        return water;
    }

    //better TC -> O(n) SC -> O(n) 
    //keeping track of rightmax using suffixmax and checking the conditions accordingly
    public static int trapWater2(int[] arr) {
        int n = arr.length;
        int water = 0;
        int[] suffix = new int[n];
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        int leftmax = 0;
        for (int i = 0; i < n; i++) {
            leftmax = Math.max(arr[i], leftmax);
            int rightmax = suffix[i];
            water += Math.min(leftmax, rightmax) - arr[i];
        }
        return water;
    }

    //optimal TC->O(n) SC->O(1) using two pointer keeping track of leftmax and rightmax
    //performing the operations as above  
    public static int trapWater3(int[] arr) {
        int n = arr.length;
        int water = 0;

        int left = 0, right = n - 1;
        int leftmax = arr[left], rightmax = arr[right];

        while (left < right) {
            if (arr[left] < arr[right]) {
                left++;
                leftmax = Math.max(leftmax, arr[left]);
                water += leftmax - arr[left];
            } else {
                right--;
                rightmax = Math.max(rightmax, arr[right]);
                water += rightmax - arr[right];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        // int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] arr = {2,3,2};
        System.out.println(trapWater3(arr));
    }
}
