package Practice

-Problems.Stack;

import java.util.Arrays;
import java.util.Stack;

/*
LeetCode -> 739 Daily Temperatures
we need to calculate when can can we get next warmer day count the number of days and return the ans array

 */
public class DailyTemps {

    //Brute force for this one as it is (Next greater element)
    //instead of storing values we store indices j-i
    public static int[] warmDay(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    //O(2n) <- TC 
    //Just like next greater element instead of storing the actual values inside the stack
    //we store indices of the array 
    //be careful while comparing because we have to compare values not indices 
    //if by mistake we compare indexes error
    //i'm talking about this one {arr[st.peek()]<=arr[i]}
    public static int[] warmDays(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = warmDays(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
