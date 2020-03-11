import java.util.ArrayList;
import java.util.Scanner;

public class grid {
    private static int[] move = {0,0,-1,1};//move vertically or horizontally
    private static int[] move2 = {-1,1,0,0};
    public static boolean bound(int row, int col, int N, int M){
        return (row >= 0 && row < N && col >= 0 && col < M);
    }

    public static int solveGrid(int[][] board, int[][] dist) {
        int N = board.length;
        int M = board[0].length;
        Gridpoint start = new Gridpoint(0, 0);
        ArrayList<Gridpoint> queue = new ArrayList<>();
        queue.add(start);
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            Gridpoint curr = queue.remove(0);
            int r = curr.r;
            int c = curr.c;
            for (int i = 0; i < 4; i++) {
                if (bound(r + board[r][c] * move[i], c + board[r][c] * move2[i], N, M)) {
                    if (dist[r + board[r][c] * move[i]][c + board[r][c] * move2[i]] == -1) {
                        queue.add(new Gridpoint(r + board[r][c] * move[i], c + board[r][c] * move2[i]));
                        dist[r + board[r][c] * move[i]][c + board[r][c] * move2[i]] = dist[r][c] +1;
                    }
                }
            }
        }
        return dist[N-1][M-1];
    }


    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        if (N == 0 && M == 0) {
            System.out.println(-1);
        }
        int[][] space = new int[N][M];
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = scan.next();
            for(int j = 0; j < M; j++){
            space[i][j] = Integer.parseInt(line.substring(j,j+1));
            dist[i][j] = -1;
            }
        }

        int result = solveGrid(space, dist);
        System.out.println(result);
    }
}
class Gridpoint{
    int r,c;
    public Gridpoint(int a, int b){
        r =a;
        c = b;
    }
}
