package Practice

import java.util.Arrays;



-Problems.BinarySearch;


/*
In How much speed the monkey can eat all the bananas in the provided time
Binary search can be applied over here
we need to check with all the speed's whether it can cover all the banana's in that specific time
so we simply check from the middle just like lower bound 
*/

public class KokoEatingBananas {

    //Brute Force Approach O(n*2)
    public static int speedOfEatingBanana1(int[] arr, int h) {
        int n = arr.length;
        int low = 1;
        int high = Arrays.stream(arr).max().orElse(-1);
        for (int k = low; k <= high; k++) {
            int hours = 0;
            for (int p : arr) {
                hours += Math.ceil((double) p / k);
            }
            if (hours <= h) {
                return k;
            }
        }
        return -1;
    }

    //Optimal Approach 
    public static int speedOfEatingBanana2(int[] arr, int h) {
        int n = arr.length;
        int low = 1;
        int high = Arrays.stream(arr).max().orElse(-1); //setting up the limit is very imp because we are going to eliminate max number of operations over there

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEat(arr, h, mid)) {//If it can eat in this (mid) time we will store that into the answer 
                ans = mid;
                high = mid - 1; //just like lower bound we will check whethere there is chance for lower speed can cover or not
            } else {
                low = mid + 1; //if it cannot handle all the bananas with the {mid} speed we will go even higher
            }
        }
        return ans;
    }

    public static boolean canEat(int[] arr, int h, int k) {
        int hours = 0;
        for (int p : arr) {
            hours += Math.ceil((double) p / k);
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        int h = 8;
        System.out.println(speedOfEatingBanana2(arr, h));
    }
}
