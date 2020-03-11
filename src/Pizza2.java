/*
 *   Implements Kadane Algorithm (Dynamic programming problem, max sum of a sub-array)
 */

import java.util.Scanner;

import static java.lang.Integer.max;

public class Pizza2
{
    /* Function to largest subarray*/
    public static int maxSubSequence(int[] arr)

//  Kadane's Algorithm
    {
        int maxprofit = arr[0], maxcurrent = arr[0];

        for (int i = 1; i < arr.length; i++)
        {
            /* calculate maxEndingHere */
            maxcurrent = max(arr[i], maxcurrent+=arr[i]);
            maxprofit = max(maxprofit, maxcurrent);
        }
        return maxprofit;
    }
    /* Main function */
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // num of breaks
        int P = scan.nextInt(); // price
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = (scan.nextInt()- P);
        }
        int profit = maxSubSequence(arr);
        System.out.println(profit);
    }
}