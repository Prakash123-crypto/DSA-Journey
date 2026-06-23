package PracticeProblems.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    //Brute Force O(n*2)
    public static int[] nge(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }
        res[n - 1] = -1;
        return res;
    }

    //O(n) optimal using stack
    //take stack and check on the top element and compare with arr[i]
    //while small pop else add it to the list whichever is in top of the stack 
    public static List<Integer> nge2(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(-1);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                lst.set(i, stack.peek());
            }
            stack.push(arr[i]);
        }
        return lst;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};// o/p-> [3,4,4,-1]
        List<Integer> res = nge2(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
