package Practice

-Problems.Arrays.TwoPointers;


//leetcode problem -> 

public class ContainsMostWater {

    //brute force O(n*2)
    public static int findMaxWaterContains(int[] arr) {
        int n = arr.length;
        int maxArea = 0;
        for (int left = 0; left < n - 1; left++) {
            for (int right = left + 1; right < n; right++) {
                int height = Math.min(arr[left], arr[right]);
                int width = right - left;
                int area = height * width;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    //the formula for finding the area is height * width so we find that first 
    // and calculate the area accordingly 
    //we have to take the min value of both pointers cause overflow may happen if we try and pick bigger one
    //TC -> O(n)
    public static int findMaxWater(int[] arr) {
        int n = arr.length;

        int maxArea = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (arr[left] <= arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = findMaxWater(arr);
        System.out.println(res);
    }
}
