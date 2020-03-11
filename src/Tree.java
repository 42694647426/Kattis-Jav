import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Tree {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Node[] nodes = new Node[101];
            for (int i = 1; i < 101; i++) nodes[i] = new Node(i);
            Node current = nodes[Integer.parseInt(in.readLine())];
            while(true) {
                int[] val = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int parent = val[0];
                if (parent == -1) break;
                for (int i = 1; i < val.length; i++) nodes[val[i]].parent = nodes[parent];
            }
            String output ="";
            output += current.value;
            current = current.parent;

            while (current != null) {
                output += " "+ current.value;
                current = current.parent;
            }
            System.out.println(output);


    }
}
class Node {
    public Node parent;
    public int value;

    public Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

    public Node(int value) {
        this(value, null);
    }
}
