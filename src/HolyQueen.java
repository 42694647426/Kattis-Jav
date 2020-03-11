import java.util.Arrays;
import java.util.Scanner;


public class HolyQueen {

    public static int machine(int[] arr, int S, int C, int K) {
        int nummachine = 1, numsocks = 1, diff = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if(numsocks>=C||arr[i]-diff > K){
                nummachine++;
                diff = arr[i];
                numsocks=1;
            }else numsocks++;

        }
        return nummachine;
    }
    /* Main function */
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);


        while(true) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            if(N==0&&M==0){
                break;
            }
            int[] hole = new int[N*2];
            for (int i = 0; i < hole.length; i++){
                hole[i] = scan.nextInt();
            }

        }


    }
}