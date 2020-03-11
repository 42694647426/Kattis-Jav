import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bus {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        if (N == 0) {
            System.out.println(0);
        }

        ArrayList<Integer> Bus =new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int temp = scan.nextInt();
            Bus.add(temp);
        }
        Collections.sort(Bus);
        String output = ""+Bus.get(0);
        for (int i =1; i<N; i++){
            if(Bus.get(i)==Bus.get(i-1)+1){

                if(N>i+1&&Bus.get(i+1)==Bus.get(i)+1){
                    output+="-";
                    i+=2;
                    while(N>i &&Bus.get(i)==Bus.get(i-1)+1)i++;
                    i--;
                    output+=Bus.get(i);
                }else output+=" "+Bus.get(i);
            }else output+=" "+Bus.get(i);
        }
        System.out.println(output);
    }
}




