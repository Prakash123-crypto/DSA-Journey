
public class MinIceCreamBars1833{

    //brute force O(n log n)
    public static int countIceBarsCanBuy(int[] costs,int coins){
        int cnt = 0;

        for(int cost : costs){
            if(cnt>coins){
                break;
            }
            coins-=cost;
        }
        return cnt;

    }

    //optimal using greedy O(n) space -> O(100001)
    public static int countIceBars(int[] costs,int coins){
        int[] freq = new int[100001];
        for(int cost:costs){
            freq[cost]++;
        }
        int cnt = 0;
        for(int cost=1;cost<100001;cost++){
            if(freq[cost]==0){
                continue;
            }
            int canbuy = Math.min(freq[cost],coins/cost);

            cnt += canbuy;
            coins -= canbuy*cost;

        }

        return cnt;

    }

    public static void main(String[] args) {
        int[] arr = {10,10,20,20,30};
        int coins = 70;
        System.out.println(countIceBarsCanBuy(arr, coins));
    }
}