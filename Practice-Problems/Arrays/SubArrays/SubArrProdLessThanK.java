package Practice

-Problems.Arrays.SubArrays;

//LeetCode -> 713 problem medium

public class SubArrProdLessThanK {

    //brute force for this problem
    //just go through all the subarrays which were there
    //also one interesting thing about the inside j loop which iterating backwards
    /*
    [6]
    [2,6]
    [5,2,6]
    [10,5,2,6] if we try to iterate from backword it will be clean and more efficient
    
    from front 
    [10]
    [10,5]
    [10,5,2] constant 
     */
    public static int countSubArrProdLessThanK1(int[] arr, int k) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < i; j++) {
                prod *= arr[i];
                if (prod < k) {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }

    //Optimal solution O(2n) 
    //increase the window until prod exceeds k and decrease the prod until 
    //prod becomes lesser than the k
    //count will count all the subarrays within the given range by the most famous formula right-left+1
    //
    public static int countSubArrProdLessThanK2(int[] arr, int k) {
        if (k <= 1) {
            return 0;
        }

        int n = arr.length;
        int cnt = 0;
        int left = 0;
        int prod = 1;

        for (int right = 0; right < n; right++) {
            prod *= arr[right];
            while (prod >= k) {
                prod /= arr[left];
                left++;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 6};
        int k = 100;
        System.out.println(countSubArrProdLessThanK2(arr, k));
    }
}
