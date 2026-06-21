package Practice

-Problems.Arrays;

import java.util.*;

public class ThreeSum {


    //brute force O(n*3)
    public static List<List<Integer>> sum3(int[] arr) {
        int n = arr.length;

        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == 0) {
                        List<Integer> sorted = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(sorted);
                        res.add(sorted);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    //optimal two pointer with dynamic window O(n*2)
    public static List<List<Integer>> sum3(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();

        //With this solution we no longer need to use set to store without dups because we are handling 
        //all of the dups with while loops by pushing forward if any dups occurs

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) { //[-1,-1,-1,0,0,0,2,2,3] here we know at idx 1 
                                                // and 2 we cannot from a triplet cause of it's repeating
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    res.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    while (j < k && arr[j] == arr[j + 1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, -1, -1, 0, 0, 0, 2, 2, 3};

        System.out.println(sum3(arr));
    }
}
