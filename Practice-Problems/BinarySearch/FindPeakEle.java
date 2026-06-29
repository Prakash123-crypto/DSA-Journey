package Practice

-Problems.BinarySearch;


/*
LeetCode -> 162
The problem is to return the peak element 
the peak element is where its right and left are strictly less than that number [1,2,3,1] here 3

To Solve this we first check whether the the mid >mid+1 if that's the case we may find the peak left side of the array
Else we may find the peak right side
*/
public class FindPeakEle {

    public static int peak(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] > arr[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[l];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(peak(arr));
    }
}
