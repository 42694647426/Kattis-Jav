import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.System.exit;

public class Restaurant {
    public static int solveOrder(int[] price, int m, int n) {
        if (n == 0) return 1;
        else if (n < 0) return 0;
        else if (m <= 0 && n >= 1) return 0;
        return solveOrder(price, m - 1, n) + solveOrder(price, m, n - price[m - 1]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();


        int[] price = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = scan.nextInt();
        }
        int M = scan.nextInt();

        int[] order = new int[M];
        for (int i = 0; i < M; i++) {
            order[i] = scan.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int result = solveOrder(price, N, order[i]);
            if (result == 0) System.out.println("Impossible");
            else if (result > 1) System.out.println("Ambiguous");
            else {
                ArrayList<Integer> dish = new ArrayList<>();
                if (solveOrder(price, N - 1, order[i]) == 1) {
                    int z = 1;
                    int temp = order[i];

                    while (z < N) {
                        if (solveOrder(price, N - z, temp) == 1) {
                            if (solveOrder(price, N - z - 1, temp) == 1) {
                                z++;
                            } else {
                                dish.add(N - z);
                                temp = temp - price[N - z - 1];
                            }
                        }

                        if (temp == 0) {
                            break;
                        }

                    }
                } else if (solveOrder(price, N, order[i] - price[N - 1]) == 1) {
                    int z = 0;
                    dish.add(N);
                    int temp = order[i] - price[N - 1];

                    while (z < N) {
                        if (solveOrder(price, N - z, temp) == 1) {
                            if (solveOrder(price, N - z - 1, temp) == 1) {
                                z++;
                            } else {
                                temp = temp - price[N - z - 1];
                                dish.add(N - z);
                            }
                        }
                        if (temp == 0) {
                            break;
                        }
                    }
                }
                Collections.sort(dish);
                for (int j = 0; j < dish.size(); j++) {
                    System.out.print(dish.get(j));
                    if (j < dish.size() - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

        }
    }
}
