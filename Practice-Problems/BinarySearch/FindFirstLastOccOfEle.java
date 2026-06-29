package Practice

-Problems.BinarySearch;

public class FindFirstLastOccOfEle {

    public static int[] findFirstLastOcc(int[] arr, int tar) {

        int first = findFirst(arr, tar);
        int last = findLast(arr, tar);
        return new int[]{first, last};
    }

    private static int findFirst(int[] arr, int tar) {
        int l = 0, r = arr.length - 1;

        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < tar) {
                l = mid + 1;
            }
            if (arr[mid] == tar) {
                ans = mid;
                r = mid - 1;
            } else if (arr[mid] > tar) {
                r = mid - 1;
            }
        }
        return ans;
    }

    private static int findLast(int[] arr, int tar) {
        int l = 0, r = arr.length - 1;

        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < tar) {
                l = mid + 1;
            }
            if (arr[mid] == tar) {
                ans = mid;
                l = mid + 1;
            } else if (arr[mid] > tar) {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println();
    }
}
