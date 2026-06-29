package Practice

-Problems.BinarySearch;

public class RotateArray {

    //Brute force approach TC -> O(n*2)
    public static void rightRotateOrColckWise1(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        for (int i = 0; i < k; i++) {
            int temp = arr[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = temp;
        }
    }

    //Not Brute at the same time not Optimal TC -> O(n) SC -> O(n)
    public static void rightRotateOrColckWise2(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            int newIdx = (i + k) % n;
            temp[i] = arr[newIdx];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    //Optimal TC-> O(n) SC -> O(1)
    public static void rightRotateOrColckWise3(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    public static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
