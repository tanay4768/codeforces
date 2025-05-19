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
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

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
        while (t > 0) {
            t--;
            int n = in.nextInt();
            String s = in.nextLine();
            
            out.println(count(n, s));

        }
        out.flush();
    }

    public static int count(int n, String s) {
        int count = 0;
        int start = -1;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '.') {
                count++;
                end = i;
            } else
                start = i;

            if (end - start >= 3) {
                return 2;
            }
        }
        return count;
    }
}
