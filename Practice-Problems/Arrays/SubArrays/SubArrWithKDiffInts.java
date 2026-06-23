-Problems.Arrays.SubArrays;

import java.util.HashMap;


//LeetCode -> 239 Hard level
/*
The problem is about counting all the subarrays present in the array 
condition: the elements in the subarray should be unique of size k
Brute force:
To solve this thing take map and put the values into it until size of map becomes k
if size of map ==k count else size>k break from the loop

optimal:
again same procedure using map and initialize two pointer and expand using right window
shrink using left window by checking some conditions and the conditions are map size>k(shrink)
this will give all the subarays that are less than equal to k
but we want only equal to k for that we need to find for k and also k-1 if we subtract them we will get answer
*/

public class SubArrWithKDiffInts {

    //Brute force approach TC->O(n*2)
    public static int countValidSubs1(int[] arr, int k) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = i; j < n; j++) {
                hm.put(arr[j], hm.getOrDefault(arr[j], 0) + 1);
                if (hm.size() == k) {
                    cnt++;
                } else if (hm.size() > k) {
                    break;
                }
            }
        }
        return cnt;
    }

    //Optimal TC->O(4n)
    public static int countValidSubs2(int[] arr, int k) {
        return countValid(arr, k) - countValid(arr, k - 1);
    }

    public static int countValid(int[] arr, int k) {
        int n = arr.length;
        int cnt = 0;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(countValidSubs1(arr, k));
    }
}
