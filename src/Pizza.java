import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Integer.max;


class Pizza {

    public static void main (String [] args) throws IOException {
        BufferedReader buffer =new BufferedReader(new InputStreamReader(System.in));
        String Init = buffer.readLine(); // read first line
        String breaks = buffer.readLine();
        String[] init= Init.split(" ");
        int numbreak  = Integer.parseInt(init[0]);
        int price  = Integer.parseInt(init[1]);
        String [] breakarr = breaks.split(" ");
        int profit  = 0;
        int currentprofit = 0;
        for (int i =0; i<numbreak; i++){
            currentprofit += Integer.parseInt(breakarr[i]) ;
            profit = max(profit, currentprofit - price*(i+1));
            int currprofit = 0;
            for (int j = i+1; j<numbreak; j++){
                currprofit += Integer.parseInt(breakarr[j]) ;
                profit = max(profit, currprofit - price*(j-i));
            }
        }
        System.out.println(profit);
    }

}
