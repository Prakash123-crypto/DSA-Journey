
public class ProdOfArrExceptItself {

    //Brute force approach
    public static int[] prodOfArr1(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    prod *= arr[j];
                }
            }
            ans[i] = prod;
        }
        return ans;
    }

    //Optimal solution using prefixsum approach
    //calculate left prod and keep track of right prod and in the end multiply both left and right prod store it in ans[]
    public static int[] prodOfArr2(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        //prefix multiplication of left part
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * arr[i - 1];
        }
        //instead of wasting one more array for suffix product we calculate in the array itself
        int rightProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * rightProd;
            rightProd *= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};// ->o/p [60,40,30,24]
        int[] res = prodOfArr1(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
