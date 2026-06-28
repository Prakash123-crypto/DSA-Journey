package Practice

-Problems.BinarySearch;


/*
The logic is simple here first we check for the arr[mid]== tar if that's the case we simply return that

Then we check if it is left sorted or right sorted for example [5,6,7,8,0,1,2,3] l = 0,mid = 3,r = n
in this case left is sorted so we will simply check if the target element is there in left part 
if it is there we simply move the right to mid-1 because that's where the target lies
and if the target was not there in the left part we go to right part

Same thing for right sorted too first we check if the target element is there in the right
if there we will move the l = mid+1 and the find the element like we usually do in binary search
if the element is not there in the right half we go to the left half

*/
public class SearchInRotatedArr {

    public static int serachIndex(int[] arr, int tar) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == tar) {
                return mid;
            }
            if (arr[left] <= arr[mid]) { //left sorted
                if (arr[left] <= tar && arr[mid] > tar) { // target element there in the left
                    right = mid - 1;
                } else {                        // target element not there int the left
                    left = mid + 1;
                }
            } else {      //right sorted
                if (arr[mid] < tar && arr[right] > tar) {  // target element there in the right
                    left = mid + 1;
                } else {        // target element not there in the right so go to left
                    right = mid - 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        int tar = 1;
        System.out.println(serachIndex(arr, tar));
    }
}
