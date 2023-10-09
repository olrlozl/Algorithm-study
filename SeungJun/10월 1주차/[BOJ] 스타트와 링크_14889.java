import java.io.*;
import java.util.*;

public class Main {
    public static int[][] table;
    public static int min = Integer.MAX_VALUE;

    public static void combination(boolean[] visit, int idx, int cnt) {
        if (cnt == visit.length / 2) {
            int total = 0;

            for (int i = 0; i < table.length - 1; i++) {
                for (int j = i + 1; j < table.length; j++) {
                    if (visit[i] && visit[i] == visit[j]) total += table[i][j] + table[j][i];
                    else if (!visit[i] && visit[i] == visit[j]) total -= table[i][j] + table[j][i];
                }
            }

            min = Math.min(min, Math.abs(total));

            return;
        }
        else if (idx == visit.length) return;

        visit[idx] = true;
        combination(visit, idx + 1, cnt + 1);
        visit[idx] = false;
        combination(visit, idx + 1, cnt);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        table = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(new boolean[n], 1, 0);

        bw.write(min + "");
        bw.close();
    }
}