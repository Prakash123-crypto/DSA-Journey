/*
Platform : LeetCode
Problem  : Finding The Highest Altitude
Difficulty : Easy
Topic : Normal Easy
Date : 19-06-2026

TC : O(n)
SC : O(1)
 */

import java.util.*;

public class FindHighestAltitude19 {

    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + gain[i - 1];
        }
        int res = Arrays.stream(arr).max().orElse(-1);
        return res;
    }
}
