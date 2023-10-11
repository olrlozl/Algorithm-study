import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public static int time = 0;

    public static int bfs(int[][] arr, Point baby_shark, int size) {
        Queue<Point> queue = new LinkedList<>();
        Point next = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        int[][] visit = new int[arr.length][arr.length];

        queue.add(baby_shark);

        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                Point now = queue.poll();

                for(int j = 0; j < 4; j++) {
                    int nr = now.x + delta[j][0];
                    int nc = now.y + delta[j][1];

                    if(nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length || (nr == baby_shark.x && nc == baby_shark.y)|| size < arr[nr][nc] || visit[nr][nc] != 0) continue;

                    if(arr[nr][nc] != 0 && arr[nr][nc] < size) {
                        if(nr < next.x || (nr == next.x &&  nc < next.y)) {
                            next.x = nr;
                            next.y = nc;
                        }

                        visit[nr][nc] = visit[now.x][now.y] + 1;
                    }
                    else {
                        queue.add(new Point(nr, nc));
                        visit[nr][nc] = visit[now.x][now.y] + 1;
                    }
                }
            }

            if(next.x != Integer.MAX_VALUE) {
                arr[baby_shark.x][baby_shark.y] = 0;

                baby_shark.x = next.x;
                baby_shark.y = next.y;

                arr[baby_shark.x][baby_shark.y] = 9;

                return visit[baby_shark.x][baby_shark.y];
            }
        }

        return -1;
    }
    public static void eating(int[][] arr, Point baby_shark) {
        int size = 2, eat = 0;

        while(true) {
            int k = bfs(arr, baby_shark, size);

            if(k == -1) return;
            else {
                time += k;
                eat++;

                if(eat == size) {
                    size++;
                    eat = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        Point baby_shark = new Point();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 9) {
                    baby_shark.x = i;
                    baby_shark.y = j;
                }
            }
        }

        eating(arr, baby_shark);

        bw.write(time + "");
        bw.close();
    }
}