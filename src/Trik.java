import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Trik {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        String input = in.nextLine(); //read input
        int[] cups = {1,0,0}; //create 3 cups
        for (char i : input.toCharArray()) {
            if (i == 'A'){ //switch position
                int state = cups[0];
                cups[0] = cups[1];
                cups[1] = state;
            }
            else if(i == 'B'){
                int state = cups[1];
                cups[1] = cups[2];
                cups[2] = state;
            }
            else if(i == 'C'){
                int state = cups[0];
                cups[0] = cups[2];
                cups[2] = state;
            }
            else{
                throw new IllegalArgumentException("Illegal input, please retry!");//throw exception
            }
        }
        if (cups[0] == 1){ //output
            out.println(1);
        }
        else if(cups[1] == 1){
            out.println(2);
        }
        else{
            out.println(3);
        }

        out.close();
    }

}

