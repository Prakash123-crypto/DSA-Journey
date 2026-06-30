package Practice

-Problems.Strings;


/*
LeetCode ->680
we just have to check whether the given string is palindrome or not 
also small twist we can ignore or remove k character 
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

The theory is simple over here and that is 
check from left side and right side and we will give exception for one character
for example "afgfea" a and a are equal we go forward
now f and e are not equal so we check by leaving f -> gfe which is not   palindrome 
so we check by removing one character at end and that is "e" so now "fgf" is palindrome which is true
so this is the  whole concept behind it
*/

public class ValidPalindromeII {

    //Brute force approach which we will check every possiblity by removing one one character from start to end
    public static boolean isValidPalin1(String s) {
        int n = s.length();

        if (isPalin(s)) {
            return true;
        }

        for (int i = 0; i < n; i++) {

            String temp = s.substring(0, i) + s.substring(i + 1);

            if (isPalin(temp)) {
                return true;
            }

        }
        return false;
    }

    public static boolean isPalin(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //optimal approach which takes nearly O(2n) nearly
    public static boolean isValidPalin2(String s) {
        int n = s.length();

        int left = 0, right = n - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return (isPalindrome(s, left + 1, right)
                        || isPalindrome(s, left, right + 1));
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "afgfea";
        System.out.println(isValidPalin2(s));
    }
}
