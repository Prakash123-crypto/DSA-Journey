package Practice

-Problems.BinarySearch;


/*
LeetCode -> 69
Binary Search

*/
public class SqrtOfX {

    public static int sqrt(int n) {
        long l = 1;
        long r = n / 2;
        while (l < r) {
            long mid = l + (r - l) / 2;
            long square = mid * mid;
            if (square == n) {
                return (int)mid;
            } else if (square < n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int)r;

    }

    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(sqrt(x));
    }
}
