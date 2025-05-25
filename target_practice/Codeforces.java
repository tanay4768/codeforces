package target_practice;

import java.io.*;
import java.util.*;

public class Codeforces {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        // Skips empty lines automatically
        String nextLine() {
            String str = "";
            try {
                while ((str = br.readLine()) != null && str.trim().isEmpty()) {
                    // skip empty lines
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
       while (t> 0) {
            t--;
            char[][] board = new char[10][10];
            for(int i=0; i<10; i++){
                String s = in.nextLine();
                board[i]= s.toCharArray();
            }
            out.println(countTotal(board));
        }

        out.flush();
    }

    public static int helper(char c,int val){
       return c == 'X' ? val : 0;
    }

    public static int countTotal(char[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length; 
        
        int top = 0, left = 0, bottom = n - 1, right = m - 1;
        int score = 0, val = 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++)
                score+=helper(mat[top][i], val);

            top++;


            for (int i = top; i <= bottom; i++)
                score+=helper(mat[i][right], val);

            right--;


            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    score+=helper(mat[bottom][i], val);

                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    score+=helper(mat[i][left], val);

                left++;
            }
            val++;
        }
        return score;
    }
}