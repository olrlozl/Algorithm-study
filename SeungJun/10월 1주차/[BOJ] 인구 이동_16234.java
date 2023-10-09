import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int[][]delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void bfs(int[][] arr, boolean[][] visit, int l, int r, Point p) {
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> dot = new LinkedList<>();
        int total = arr[p.x][p.y];

        queue.add(p);
        dot.add(p);
        visit[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_r = now.x + delta[i][0];
                int next_c = now.y + delta[i][1];

                if (next_r < 0 || next_r >= arr.length || next_c < 0 || next_c >= arr.length || visit[next_r][next_c] || Math.abs(arr[now.x][now.y] - arr[next_r][next_c]) < l || Math.abs(arr[now.x][now.y] - arr[next_r][next_c]) > r) continue;

                queue.add(new Point(next_r, next_c));
                dot.add(new Point(next_r, next_c));
                visit[next_r][next_c] = true;
                total += arr[next_r][next_c];
            }
        }

        int count = dot.size();

        while (!dot.isEmpty()) {
            Point now = dot.poll();

            arr[now.x][now.y] = total / count;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int t = 0;; t++) {
            boolean[][] visit = new boolean[arr.length][arr.length];
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        bfs(arr, visit, l, r, new Point(i, j));
                        count++;
                    }
                }
            }

            if (count == n * n) {
                bw.write(t + "");
                break;
            }
        }

        bw.close();
    }
}