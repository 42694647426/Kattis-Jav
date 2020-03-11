import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


class Space {

    public static void main (String [] args) throws IOException {
        BufferedReader buffer =new BufferedReader(new InputStreamReader(System.in));
        String Initsize = buffer.readLine(); // read first line
        String inputarr = buffer.readLine(); // read second line
        String[] init= Initsize.split(" "); // split into array
        int total  = Integer.parseInt(init[0]); // read as int
        int partition  = Integer.parseInt(init[1]);
        String [] arr = inputarr.split(" ");
        ArrayList<Integer> output = new ArrayList<Integer>(); // create result array
        output.add(total); // add (total - 0)
        for (int i =0; i<arr.length; i++){ // outer loop
            int curr_value = Integer.parseInt(arr[i]);
            if(!output.contains(curr_value)) output.add(curr_value); // add (all value-0)
            if(!output.contains(total-curr_value)) output.add(total-curr_value); // add(total - value)
            for(int j = i+1; j<arr.length; j++){ // inner loop add(all other value - current value)
                int new_value = Integer.parseInt(arr[j]);
                int diff = new_value - curr_value;
                if(!output.contains(diff) && diff!=0){
                    output.add(diff);
                }
            }
        }

        Collections.sort(output);//sort array
        for (int i: output){ //print out elements
            System.out.print(i+ " ");
        }
    }

}