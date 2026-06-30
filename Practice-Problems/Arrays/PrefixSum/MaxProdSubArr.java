

/*
LeetCode -> 152
We just have to return the maximum prod subarray which is present
We can just simply product from front and back and store max value from them 
then we have our answer
 */
public class MaxProdSubArr {

    public static int findMaxProd1(int[] arr) {
        int n = arr.length;
        int max = -10;

        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod *= arr[j];
                max = Math.max(max, prod);
            }
        }
        return max;
    }

    public static int findMaxProd2(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {

            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }

            prefix *= arr[i];
            suffix *= arr[n - i - 1];

            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4}; // o/p -> 6 if [2,3,-2,4,2] -> op-> 8

        System.out.println(findMaxProd1(arr));
    }
}
