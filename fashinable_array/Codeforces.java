package fashinable_array;

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
            int a[] = new int[n];
            int count = 0;
            for(int i=0; i<n; i++){
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            int i=0;
            int j = n-1;
            count = recurse(a, i, j, count);
            out.println(count);

        }
        out.flush();
    }
    public static int recurse(int[] a, int i, int j, int count){
        int k = count;
        if(i>=j || (a[i]+a[j])%2==0) return count;
        k = Math.min(recurse(a, i+1, j, count+1), recurse(a, i, j-1, count+1));
        return k;
    }
}