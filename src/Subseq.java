import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Subseq {
    public static ArrayList<Integer> lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if(nums==null || nums.length==0)
            return list;
        for(int num: nums){
            if(list.size()==0 || num>list.get(list.size()-1)){
                list.add(num);
            }else{
                int i=0;
                int j=list.size()-1;

                while(i<j){
                    int mid = (i+j)/2;
                    if(list.get(mid) < num){
                        i=mid+1;
                    }else{
                        j=mid;
                    }
                }
                list.set(j, num);
            }
        }

        return list;
    }
    public static void main(String[] args) throws  IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int j = 0;
        while(true){
            String line =in.readLine();
            String[] lines = line.split(" ");
            int nums [] = new int[lines.length];
            if(lines.length==1){
                break;
            }
            for(int i =0; i< lines.length; i++){
            nums[i] = Integer.parseInt(lines[i]);
            }
            ArrayList<Integer> list = lengthOfLIS(nums);
            result.add(list);
        }

        for (ArrayList<Integer> list : result) {
            System.out.print(list.size() + " ");
            for(int e : list){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
