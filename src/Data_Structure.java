import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Data_Structure {

    public static void main (String [] args) throws IOException {
        BufferedReader buffer =new BufferedReader(new InputStreamReader(System.in));
        String inputstr; //read input
        while((inputstr=buffer.readLine() )!=null) {
            int size =Integer.parseInt(inputstr); //read first int as size
            Stack<Integer> stack =new Stack<>(); // create stack, queue, prioqueue
            boolean isStack=true;
            Queue<Integer> queue=new LinkedList<>();
            boolean isQueue=true;
            PriorityQueue<Integer> priority =new PriorityQueue<>(Collections.reverseOrder());
            boolean isPriority=true;
            for (int i=0;i<size;i++) { //read next line
                StringTokenizer st = new StringTokenizer(buffer.readLine()); // use tokenizer to read next int

                String operat =st.nextToken(); //first in is operation
                int value=Integer.parseInt(st.nextToken());
                if (operat.equals("1")) { //add into "list"
                    stack.push(value);
                    queue.offer(value);
                    priority.offer(value);
                } else if (operat.equals("2")) { // remove from "list"
                    if (isStack && (stack.size()==0 || !stack.pop().equals(value))) isStack=false; // check if it's valid
                    if (isQueue && (queue.size()==0 || !queue.poll().equals(value))) isQueue=false;
                    if (isPriority && (priority.size()==0 || !priority.poll().equals(value))) isPriority=false;
                }
                else{ //if it's not 1 or 2 break and impossible
                    System.out.println("impossible");
                    return;
                }
            }
            //print the final result
            if (!isStack && !isQueue && !isPriority) System.out.println("impossible");
            else if ((isStack && isQueue) || (isStack && isPriority) || (isQueue && isPriority)) System.out.println("not sure");
            else if (isStack) System.out.println("stack");
            else if (isQueue) System.out.println("queue");
            else if (isPriority) System.out.println("priority queue");
        }

    }
}