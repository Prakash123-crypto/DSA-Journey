package Practice

-Problems.Arrays.SubArrays;

public class MinSizeSubArrSum {

    //brute force checking all the subarrays to find the min length of all
    //O(n*2) which will give TLE for 10*5->10*10
    public static int findMinSubArrSum1(int[] arr, int target) {
        int n = arr.length;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum >= target) {
                    int len = j - i + 1;
                    minLen = Math.min(minLen, len);
                    break;//there's no point in checking aftwerwards because sum will increase which is not we wanted
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    //Optimal Approach somewhere around O(2n) 
    //same concept of expanding and shrinking if sum>target shrink from left side
    //else expand as always and keep track of minLen always
    public static int findMinSubArrSum2(int[] arr, int target) {
        int n = arr.length;
        int minlen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            //expanding part of the problem
            sum += arr[right];
            while (sum >= target) {
                minlen = Math.min(minlen, right - left + 1);
                //shrinking part of the problem
                sum -= arr[left];
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;//[1,1,1,1,1,1] tar = 11
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3}; //here 4,3 ->7 which is target of size 2 which is the least among all
        int target = 7; //so we have to return 2 as output
        System.out.println(findMinSubArrSum2(arr, target));
    }
}
