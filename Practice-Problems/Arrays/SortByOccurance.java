package Practice-Problems.Arrays;

// import java.util.ArrayList;
import java.util.*;

public class SortByOccurance {

    public static ArrayList<Integer> sortEleByOcc(int[] arr){
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i, 0)+1);
        }
        List<Map.Entry<Integer,Integer>> lst = new ArrayList<>(hm.entrySet());

        lst.sort((a,b)->b.getValue()-a.getValue());

        ArrayList<Integer> res = new ArrayList<>();

        for(Map.Entry<Integer,Integer> e : lst){
            int freq = e.getValue();
            int key  = e.getKey();
            for(int i=0;i<freq;i++){
                res.add(key);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,3,5,4};
        ArrayList<Integer> lst = sortEleByOcc(arr);

        for(int ele : lst){
            System.out.print(ele+" ");
        }
    }
}
