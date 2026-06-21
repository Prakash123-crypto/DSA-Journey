package Practice

-Problems.Arrays.TwoPointers;

//LeetCode -> 75
//Dutch National Flag Algo to sort 0's 1's 2's
public class SortColorsDNF {

    public static int[] sortColors(int[] arr) {
        int n = arr.length;

        int low = 0, mid = 0, high = n - 1;

        //mid acts as a base for this problem
        //by checking all the cases and swapping them accordingly
        while (mid <= high) {
            if (arr[mid] == 0) {
                arr[mid] = arr[low];
                arr[low] = 0;
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                arr[mid] = arr[high];
                arr[high] = 2;
                high--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 2, 1, 0, 2, 2};
        System.out.println(sortColors(arr));
    }
}
