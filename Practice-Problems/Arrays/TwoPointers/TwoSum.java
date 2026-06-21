package Practice-Problems.Arrays;

public class TwoSum {

    //brute force approach O(n*2)
    // public static int[] sum2(int[] arr,int tar){
    //     int n = arr.length;

    //     for(int i=0;i<n-1;i++){
    //         for(int j=i+1;j<n;j++){
    //             int sum = arr[i]+arr[j];
    //             if(sum == tar){
    //                 return new int[]{i+1,j+1};
    //             }
    //         }
    //     }
    //     return new int[]{-1.-1};
    // }

    //optimal using two pointer O(n) should be sorted for Two Pointer
    public static int[] sum2(int[] arr,int tar){
        int n = arr.length;

        int i = 0,j = n-1;

        while(i < j){
            int sum = arr[i]+arr[j];
            if(sum == tar){
                return new int[]{i+1,j+1};
            }else if(sum<tar){
                i++;
            }else{
                j--;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int tar = 9;
        System.out.println(sum2(arr, tar));
    }
}
