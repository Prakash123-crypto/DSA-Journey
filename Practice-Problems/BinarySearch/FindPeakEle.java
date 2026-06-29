package Practice

-Problems.BinarySearch;


/*
LeetCode -> 162
The problem is to return the peak element 
the peak element is where its right and left are strictly less than that number [1,2,3,1] here 3

To Solve this we first check whether the the mid >mid+1 if that's the case we may find the peak left side of the array
Else we may find the peak right side

we can solve this by checking the element in right side also by changing arr[mid]>arr[mid-1]
in this case we may find one problem which is left and mid point to same index which causes TLE
to overcome this we initialize mid = mid+1 [1,2,3,1] in this case we may find this problem
*/
public class FindPeakEle {

    //Searching peak in left part
    public static int peak1(int[] arr) {
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
        return l;
    }

    //Searching peak in right side
    public static int peak2(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;

            if (arr[mid] > arr[mid - 1]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(peak2(arr));
    }
}
