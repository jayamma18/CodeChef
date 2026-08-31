import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Long> row = generatePascalsTriangle(n);

            for (long val : row) {
                output.append(val).append(" ");
            }
            output.append("\n");
        }

        System.out.print(output);
    }

    public static ArrayList<Long> generatePascalsTriangle(int n) {
        ArrayList<Long> row = new ArrayList<>();
        row.add(1L);

        long prev = 1;
        for (int i = 1; i < n; i++) {
            long curr = prev * (n - i) / i;
            row.add(curr);
            prev = curr;
        }

        return row;
    }
}