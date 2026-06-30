
import java.util.HashMap;

/*
LeetCode -> 523
The problem is about [23,2,4,6,7] & k = 6
check whether any subarray sum that is divisible by k if yes return true

for this we will take hashmap and prefixsum and continuously sum the elements 
and store the remainders and their indexes in hashmap
and check for the remainder is previously exists in the map if yes we will chek the dist. between them
if it is also greater than 2 we are going return it as true
 */
public class ContinuosSubArrSum {

    //Brute Force Approach for checking all the possible cases
    public static boolean isContinuousSum1(int[] arr, int k) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < n; j++) {
                sum += arr[i];
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    //Optimal Approach Prefix Sum + HashMap
    public static boolean isContinuousSum2(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1); //for this case [2,4] -> dry run for this u will get to know y we put it over here
        int prefixsum = 0;
        for (int i = 0; i < n; i++) {
            prefixsum += arr[i];
            int rem = prefixsum % k;

            if (hm.containsKey(rem)) {
                if (i - hm.get(rem) >= 2) {
                    return true;
                }
            } else {
                hm.put(rem, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {23, 2, 4, 6, 7}; //O/P -> True
        int k = 6;
        System.out.println(isContinuousSum1(arr, k));
    }
}
