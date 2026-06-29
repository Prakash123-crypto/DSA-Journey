package Practice

-Problems.BinarySearch;

public class FindMinRotatedArr {

    public static int findMin(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] > arr[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 0, 1, 2, 3};
        System.out.println(findMin(arr));
    }
}
