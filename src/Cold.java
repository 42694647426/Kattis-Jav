import java.util.Scanner;

public class Cold {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        if (N == 0) {
            System.out.println(0);
        }
        int[] temp =  new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            int t = scan.nextInt();
            if(t<0) {
            count++;
            }
        }

        System.out.println(count);
    }
}

