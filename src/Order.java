import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Order {

    public static void solveGrid(int[] ans, int[] price, int M){
        ArrayList<Integer> result = new ArrayList<>();
        if(ans[M] == -2){
            System.out.println("Impossible");
            return;
        }
        if(ans[M] == -1){
            System.out.println("Ambiguous");
            return;
        }
        while(M>0){
            result.add(ans[M]+1);
            M -= price[ans[M]];
        }
        if (M<0){
            System.out.println("Ambiguous");
            return;
        }
        Collections.sort(result);
        for(int i =0; i<result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
        return;
    }

    public static void main(String[] args) {
        int[] answer = new int[32000] ;
        Arrays.fill(answer,-2);
        answer[0] = 0;

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[] price = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = scan.nextInt();
        }
        for(int i =0; i<N; i++){
            int cost = price[i];
            for(int j=0; j<=30000;j++){
                if(answer[j] >=0){
                    if(answer[j+cost]==-2){
                        answer[j+cost]= i;
                    }
                    else {
                        answer[j+cost] =  -1;
                    }
                }
                if(answer[j] == -1) {
                    answer[j+cost] =-1;
                }
            }
        }
        int M = scan.nextInt();

        int[] order = new int[M];
        for (int i = 0; i < M; i++) {
            order[i] = scan.nextInt();
        }
        scan.close();
        for (int i = 0; i < M; i++) {
            solveGrid(answer,price,order[i]);
        }
    }
}
