package Practice

-Problems.Arrays.SubArrays;

import java.util.HashMap;

/*
LeetCode -> 904
firstly what is the question?[1,2,3,2,2]
we will be having two buckets we can store only two elements from above array
we need to find the maximum length possible here in this case is [2,3,2,2]
cause it holds only two elements 
 */
public class FruitsIntoBasket {

    //brute force
    //just insering into map if it crosses the len(map)>2 we will break out until then we will count
    //after breaking we will update the maximum
    public static int countFriuts1(int[] arr) {
        int n = arr.length;
        int maxLen = 0;

        for (int left = 0; left < n; left++) {
            int cnt = 0;
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int right = 0; right < n; right++) {
                hm.put(arr[right], hm.getOrDefault(arr[right], 0) + 1);
                if (hm.size() > 2) {
                    break;
                }
                cnt++;
            }
            maxLen = Math.max(maxLen, cnt);
        }
        return maxLen;
    }

    //Optimal Approach TC->O(2n) 
    //Inserting into map and if len(map)>2 we will remove the first inserted values through left pointer
    //else we will expand the window by right pointer and keep track of maxLen 
    public static int countFriuts2(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        int left = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int right = 0; right < n; right++) {
            hm.put(arr[right], hm.getOrDefault(arr[right], 0) + 1);
            while (hm.size() > 2) {
                hm.put(arr[left], hm.get(arr[left]) - 1);
                if (hm.get(arr[left]) == 0) {
                    hm.remove(arr[left]);
                    left++;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2};
        System.out.println(countFriuts2(arr));
    }
}
