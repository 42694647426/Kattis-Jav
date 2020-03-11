import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sum_Square {
    public static void main (String [] args) throws IOException {
        BufferedReader buffer =new BufferedReader(new InputStreamReader(System.in));
        String inputstr; //read input
        if((inputstr=buffer.readLine() )!=null) {
            int size =Integer.parseInt(inputstr); //read first int as size
            int[][] result  = new int[size][2];
            for (int i=0;i<size;i++) { //read next line
                StringTokenizer st = new StringTokenizer(buffer.readLine());// use tokenizer to read next int
                int index = Integer.parseInt(st.nextToken()); // index number;
                int base =Integer.parseInt(st.nextToken()); //first is base number
                int sum = Integer.parseInt(st.nextToken());//second is sum
                int[] arrayA = new int[sum];
                int iter = 0;
                int squares = 0;

                while(sum!=0){
                    arrayA[iter] = sum % base;
                    sum /= base;
                    iter++;
                    System.out.print(sum);
                }
                for(int j =iter; j>=0; j--){
                    System.out.println(arrayA [j]);

                    squares += Math.pow(arrayA[j],j);
                }
                result[i][0] = index;
                result[i][1] = squares;

            }
            for (int i=0;i<size;i++){
                System.out.println(result[i][0]+" "+ result[i][1]);
            //print the final result
                }

        }

    }

}
