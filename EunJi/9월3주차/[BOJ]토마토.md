# [Gold V] 토마토 - 7576 

[문제 링크](https://www.acmicpc.net/problem/7576) 

### 성능 요약

메모리: 119960 KB, 시간: 624 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 문제 설명

<p>철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. </p>

<p style="text-align: center;"><img alt="" src="" style="width: 215px; height: 194px;"></p>

<p>창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.</p>

<p>토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.</p>

### 입력 

 <p>첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.</p>

<p>토마토가 하나 이상 있는 경우만 입력으로 주어진다.</p>

### 출력 

 <p>여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.</p>

### 나의 풀이
```java
import java.io.*;
import java.util.*;

public class Main {
    // 유니온 (두 그래프 합치기)
    public static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    // 파인드 (부모 노드 찾기)
    public static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        else return find(parent, parent[x]);
    }

    // 크루스칼 (최소 신장 트리 알고리즘)
    public static int kruskal (int[][] graph, int[] parent, int M) {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (find(parent, graph[i][0]) != find(parent, graph[i][1])) {
                union(parent, graph[i][0], graph[i][1]);
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 국가 수
            int M = Integer.parseInt(st.nextToken()); // 비행기 종류

            // 비행기 스케줄
            int[][] graph = new int[M][2];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                graph[i][0] = Integer.parseInt(st.nextToken());
                graph[i][1] = Integer.parseInt(st.nextToken());
            }

            // 부모노드 초기화
            int[] parent = new int[N + 1];
            for (int i = 1; i <= N; i++) parent[i] = i;

            // 크루스칼 함수 호출
            bw.write(kruskal(graph, parent, M) + "\n");
        }
        bw.close();
    }
}
```
