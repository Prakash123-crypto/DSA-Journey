package Practice

-Problems.Arrays.SubArrays;

//LeetCode-> 1004 medium

public class MaxConsecutiveOnesIII {

    //Brute force just add upto the limit of k and if it crosses exit the inner loop and store 
    //the right - left + 1 here +1 because we need to caluculate before breaking the condition too
    //that is the reason for +1 
    public static int maxOnes1(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;
        for (int left = 0; left < n; left++) {
            int cnt = 0;
            for (int right = left; right < n; right++) {
                if (arr[right] == 0) {
                    cnt++;
                }
                if (cnt > k) {
                    break;
                }
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }

    //Better approach which will take O(2n)TC
    //we will just count the 0's through right and if count increases k we will use
    //while loop to decrease the count(distance) and move left towards right where it will be valid 
    public static int maxOnes2(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int maxLen = 0;
        int cnt = 0;
        for (int right = 0; right < n; right++) {
            if (arr[right] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (arr[left] == 0) {
                    cnt--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    //Optimal approach which will take O(n)
    //same like above but we will increase the left while moving the right,
    //without right waiting for left-> [1,1,1,0,0,0,1,1,1,1,0]
    public static int maxOnes3(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int cnt = 0;
        for (int right = 0; right < n; right++) {
            if (arr[right] == 0) {
                cnt++;
            }
            if (cnt > k) {
                if (arr[left] == 0) {
                    cnt--;
                }
                left++;
            }
        }
        return n - left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(maxOnes1(arr, k));
    }
}
