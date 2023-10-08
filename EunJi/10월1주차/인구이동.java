import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int n;
    public static int L;
    public static int R;

    public static void bfs(boolean[][] visit, int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> move = new ArrayList<>();

        queue.add(new Point(r, c));
        move.add(new Point(r, c));
        visit[r][c] = true;
        int sum = arr[r][c];

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.x + delta[d][0];
                int nc = now.y + delta[d][1];
                if (0 <= nr && nr < n && 0 <= nc && nc < n && !visit[nr][nc] && L <= Math.abs(arr[nr][nc] - arr[now.x][now.y]) && Math.abs(arr[nr][nc] - arr[now.x][now.y]) <= R) {
                    queue.add(new Point(nr, nc));
                    move.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                    sum += arr[nr][nc];
                }
            }
        }

        for (int i = 0; i < move.size(); i++) arr[move.get(i).x][move.get(i).y] = sum / move.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;

        while (true) {
            int v = 0;
            boolean[][] visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        bfs(visit, i, j);
                        v++;
                    }
                }
            }
            if (v == n * n) {
                bw.write(day + "");
                break;
            }
            day++;
        }

        bw.close();
    }
}
