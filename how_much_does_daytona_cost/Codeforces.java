package  how_much_does_daytona_cost;

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
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++){
                a[i] = in.nextInt();
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            if(map.containsKey(k)) out.println("Yes");
            else out.println("No");

        }
        out.flush();
    }
}