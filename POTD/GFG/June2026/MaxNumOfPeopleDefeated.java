package POTD.GFG.June2026;

public class MaxNumOfPeopleDefeated {

    public static int countPeopleDefeated1(int p) {
        int cnt = 0;
        int i = 1;
        while (p > 0) {
            int isqr = (int) Math.pow(i, 2);
            if (p - isqr > 0) {
                cnt++;
            }
            p -= isqr;
        }
        return cnt;
    }


    /*
    p = 14
    l=3,r=3
    S(3)=3(4)(7)/6​=14 
     */
    public static int countPeopleDefeated2(int p) {
        long left = 0, right = 10000;
        int ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            long sum = mid * (mid + 1) * (2 * mid + 1) / 6;

            if (sum <= p) {
                ans = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int p = 14; // suppose p is 14 i->1 to n we should calculate i*2 until p
        //1*2+2*2+3*2 -> p>=14 cnt = 3 beacause defeated 3 people

        System.out.println(countPeopleDefeated1(p));
    }
}
