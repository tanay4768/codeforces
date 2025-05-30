package sequence_game;
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

            List<Integer> list = new ArrayList<>();
            for(int i = 1; i<=n; i++){
                if(i==1) list.add(in.nextInt());
                else{
                    int x = in.nextInt();
                    if(list.get(list.size() - 1)<=x) list.add(x);
                    else{
                        list.add(x);
                        list.add(x);
                    }
                }

            }
            out.println(list.size());
            for (int num : list) {
                out.print(num + " ");
            }
           out.println("");
        }


        out.flush();
    }
}