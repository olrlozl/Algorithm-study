import java.io.*;
import java.util.*;

public class Main {
    public static int[] number;
    public static int[] operator;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void permutation(boolean[] visit, int total, int idx) {
        if (idx == number.length) {
            max = Math.max(max, total);
            min = Math.min(min, total);

            return;
        }

        boolean[] check = new boolean[4];

        for(int i = 0; i < operator.length; i++) {
            if(!visit[i] && !check[operator[i]]) {
                check[operator[i]] = true;
                visit[i] = true;

                switch (operator[i]) {
                    case 0:
                        permutation(visit, total + number[idx], idx + 1);
                        break;
                    case 1:
                        permutation(visit, total - number[idx], idx + 1);
                        break;
                    case 2:
                        permutation(visit, total * number[idx], idx + 1);
                        break;
                    case 3:
                        permutation(visit, total / number[idx], idx + 1);
                        break;
                }

                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        number = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) number[i] = Integer.parseInt(st.nextToken());

        int[] arr = new int[4];
        int total = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            total += arr[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[total];

        for (int i = 0, idx = 0; i < 4; i++) {
            for(int j = 0; j < arr[i]; j++) {
                operator[idx++] = i;
            }
        }

        permutation(new boolean[operator.length], number[0], 1);

        bw.write(max + "\n" + min);
        bw.close();
    }
}