import java.util.*;

public class Queen {

    static int[] counts = new int[13];
    static ArrayList<HashSet<int[]>> total = new ArrayList<>();

    public static boolean Bound(int i , int j , int length) {

        return (i >= 0 && i < length && j >= 0 && j < length);
    }

    public static boolean[][] queenX(boolean[][] board , int r , int c) {

        for (int i = -board.length; i < board.length; i++)
        {
            if (Bound(r + i , c + i , board.length))
                board[r + i][c + i] = true;

            if (Bound(r + i , c - i , board.length))
                board[r + i][c - i] = true;

            if (Bound(r + i , c , board.length))
                board[r + i][c] = true;

            if (Bound(r , c + i , board.length))
                board[r][c + i] = true;
        }

        return board;
    }




    public static void Nqueens(boolean[][] board , int queens , int r , int[] nums) throws InterruptedException {

        if (queens == board.length)
        {
            counts[board.length]++;
            total.get(board.length).add(nums);
            return;
        }

        for (int j = 0; j < board.length; j++)
        {

            if (!board[r][j])
            {
                if (queens == 0)
                    nums = new int[board.length];
                else
                    nums = Arrays.copyOf(nums , board.length);


                boolean[][] newBoard = queenX(clone(board) , r , j);
                nums[r] = j;
                Nqueens(newBoard , queens + 1 , r + 1 , nums);
            }
        }

    }

    public static boolean[][] clone(boolean[][] array) {
        boolean[][] newOne = new boolean[array.length][array[0].length];

        for (int i = 0; i < newOne.length; i++)
            newOne[i] = Arrays.copyOf(array[i] , array[i].length);

        return newOne;
    }
    
    public static int countBreaks(HashSet<int[]> arrs , int[] holes) {

        int count = 0;

        for (int[] queens : arrs)
            if (breaks(queens , holes))
                count++;

        return count;
    }

    public static boolean breaks(int[] queens , int[] holes) {

        for (int i = 0; i < holes.length; i += 2){
            if (queens[holes[i]] == holes[i + 1]){
                return true;}}
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 13; i++)
            total.add(new HashSet<>());

        for (int N = 1; N <= 12; N++)
        {
            boolean[][] board = new boolean[N][N];
            int[] trash = new int[0];
            Nqueens(board , 0 , 0 , trash);
        }

        while (true)
        {
            int N = scan.nextInt();
            int M = scan.nextInt();

            if (N ==0 && M == 0)
                break;

            int[] holes = new int[2*M];

            for (int i = 0; i < holes.length; i++)
                holes[i] = scan.nextInt();

            System.out.println(counts[N] - countBreaks(total.get(N) , holes));
        }

        scan.close();
    }
}