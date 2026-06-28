package Practice

-Problems.BinarySearch;

public class SearchInsertPos {

    public static int searchpos(int[] arr, int tar) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == tar) {
                return mid;
            }
            if (arr[mid] < tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5, 7, 9};
        int tar = 3;
        System.out.println(searchpos(arr, tar));
    }
}
