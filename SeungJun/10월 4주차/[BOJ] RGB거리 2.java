import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][3];
        int[][] dp = new int[n][3];
        int INF = 100000000, min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++) rgb[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i != j) dp[0][j] = INF;
            }

            dp[0][i] = rgb[0][i];

            for(int j = 1; j < n; j++) {
                dp[j][0] = rgb[j][0] + Math.min(dp[j - 1][1], dp[j -1][2]);
                dp[j][1] = rgb[j][1] + Math.min(dp[j - 1][0], dp[j -1][2]);
                dp[j][2] = rgb[j][2] + Math.min(dp[j - 1][0], dp[j -1][1]);
            }

            for(int j = 0; j < 3; j++) {
                if(i != j) {
                    min = Math.min(min, dp[n - 1][j]);
                }
            }
        }

        bw.write(min + "");
        bw.close();
    }
}