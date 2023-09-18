// 시간초과...

import java.io.*;
import java.util.*;

public class Main {

    public static void union(int[] root, int a, int b, int n) {
        root[Math.max(a, b)] = Math.min(a, b);
        for (int i = 0; i < n + 1; i++) {
            if (root[i] == Math.max(a, b)) root[i] = Math.min(a, b);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 초기 집합: {0}, {1}, {2}, ... , {n}
        int m = Integer.parseInt(st.nextToken()); // 연산 개수

        // 루트노드 초기화
        int[] root = new int[n + 1];
        for (int i = 0; i < n + 1; i++) root[i] = i;

        // m개의 연산
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int od = Integer.parseInt(st.nextToken()); // 연산 종류
            int a = Integer.parseInt(st.nextToken()); // a 집합
            int b = Integer.parseInt(st.nextToken()); // b 집합

            if (od == 0) { // 합집합
                union(root, a, b, n);
            } else if (od == 1) { // 같은 집합에 포함 되어 있는지 확인
                bw.write(root[a] == root[b] ? "YES\n" : "NO\n");
            }
        }
        bw.close();
    }
}
