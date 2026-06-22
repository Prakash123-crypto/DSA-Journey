package Practice-Problems.Arrays.TwoPointers;


//leetcode -> 283 moving zeors to end


public class MoveZerosEnd {

    public static void moveZeros(int[] arr){
        int n=arr.length;

        int left = 0;
        //wherever the right is pointing to no zero element we will swap it with 
        //left 
        for(int right=0;right<n;right++){
            if(arr[right]!=0){
                int temp = arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,3,0,14,0};
        moveZeros(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
