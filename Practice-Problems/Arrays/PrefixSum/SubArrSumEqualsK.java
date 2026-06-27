package Practice

-Problems.Arrays.PrefixSum;

import java.util.HashMap;


/*
Leet Code -> 
 */
public class SubArrSumEqualsK {

    //Brute force approach for this problem
    public static int countSubArrSumEqualsK1(int[] arr, int k) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /*
    Here we solve this problem using HashMap and there is a patter to it
    Dry run for this
    [1,-1,0,1,2,-1,3] -> here we calculate prefixsum normally and store the prefixsum and the ocuuracnces of 
    prefixsum in hashmap
    Before adding it to hashmap we check the prefixsum - k was there in map 
    if there we will take the value of the specific Key
     */
    public static int countSubArrSumEqualsK2(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int prefixSum = 0;
        int cnt = 0;

        for (int num : arr) {
            prefixSum += num;

            if (hm.containsKey(prefixSum - k)) {
                cnt += hm.get(prefixSum - k);
            }
            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 0, 1, 2, -1, 3};
        int k = 3;
        System.out.println(countSubArrSumEqualsK2(arr, k));
    }
}
