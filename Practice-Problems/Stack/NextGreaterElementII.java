package Practice

-Problems.Stack;

import java.util.Arrays;
import java.util.Stack;

/*
LeetCode -> 503 
in a circular manner we need to check for the nex greater if we have not found the next greater
we need to check for previous greater 
 */
public class NextGreaterElementII {

    //Her we will take the array if [1,2,1] we will take it as twice for Ex. [1,2,1,1,2,1]
    //in that way we can easily find the next greater and before greater
    public static int[] ngeII(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int num = arr[i % n];
            while (!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }
            if (i < n && !st.isEmpty()) {
                ans[i] = st.peek();
            }
            st.push(num);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3}; //o/p -> [2,3,4,-1,4] || [1,2,1] -> [2,-1,2]
        System.out.println(ngeII(arr));//circular 
    }
}
