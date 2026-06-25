
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
The problem is about -> for a certain window size we need to find the unique's and print or store
we can use sliding window for optimal approach 
first inserting the k size into the map and then shrinking the map from left side 
 */
public class UniqueEleInAWindow {

    //Brute force Approach
    public static List<Integer> collectUniquesInWindowSize1(int[] arr, int k) {
        int n = arr.length;
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n - k; i++) {
            Set<Integer> st = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                st.add(arr[j]);
            }
            lst.add(st.size());
        }
        return lst;
    }

    //Optimal solution 
    public static List<Integer> collectUniquesInWindowSize2(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        lst.add(hm.size());
        for (int i = k; i < n; i++) {
            int out = arr[i - k];
            hm.put(out, hm.get(out) - 1);

            if (hm.get(out) == 0) {
                hm.remove(out);
            }

            lst.add(hm.size());

            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        return lst;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 3, 4, 2, 5, 3};
        int k = 4;
        List<Integer> lst = collectUniquesInWindowSize1(arr, k);
        for (int i : lst) {
            System.out.print(i + " ");
        }
    }
}
