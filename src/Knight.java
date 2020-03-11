import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knight {
    public static boolean Bound(int i , int j , int row, int col) {
        return (i >= 0 && i < row && j >= 0 && j < col);
    }

    public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
    String v[][] = new String [5][5];
    for(int i = 0; i<5; i++){
        String line =in.readLine();
        String[] lines = line.split("");
        v[i] = lines;
    }
        boolean valid = true;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(v[i][j].equals("k")) {
                    total++;
                    if (Bound(i+2, j+1, 5,5)&&v[i+2][j+1].equals("k")) {
                        valid = false;
                        break;
                    }
                    if(Bound(i+2, j-1, 5,5)&&v[i+2][j-1].equals("k")) {
                        valid = false;
                        break;
                    }
                    if(Bound(i-2, j+1, 5,5)&&v[i-2][j+1].equals("k")) {
                        valid = false;
                        break;
                    }
                    if(Bound(i-2, j-1, 5,5)&&v[i-2][j-1].equals("k")) {
                        valid = false;
                        break;
                    }
                    if(Bound(i+1, j+2, 5,5)&&v[i+1][j+2].equals("k")) {
                        valid = false;
                        break;
                    }
                    if(Bound(i+1, j-2, 5,5)&&v[i+1][j-2].equals("k")) {
                        valid = false;
                        break;
                    }
                    if(Bound(i-1, j+2, 5,5)&&v[i-1][j+2].equals("k")) {
                        valid = false;
                        break;
                    }
                    if(Bound(i-1, j-2, 5,5)&&v[i-1][j-2].equals("k")) {
                        valid = false;
                        break;
                    }

                }
            }
        }
        if(total != 9) {
            valid = false;
        }

        if(valid) {
            System.out.println("valid");
        }
        else {
            System.out.println("invalid");
        }
    }
}
