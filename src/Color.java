import java.util.Arrays;
import java.util.Scanner;


public class Color {

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

        int S = scan.nextInt();
        int C = scan.nextInt();
        int K = scan.nextInt();
        int[] arr = new int[S];
        for (int i = 0; i < S; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        int result = machine(arr, S,C,K);
        System.out.println(result);
    }
}