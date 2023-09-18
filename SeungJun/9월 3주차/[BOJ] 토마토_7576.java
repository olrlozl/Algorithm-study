import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void bfs(int[][] arr) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Point> queue = new LinkedList<>();
        int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 1) queue.offer(new Point(i, j));
            }
        }

        while(!queue.isEmpty()){
            int len = queue.size();
            count++;

            for(int i = 0; i < len; i++){
                Point p = queue.poll();

                for(int j = 0; j < 4; j++){
                    int next_r = p.x + delta[j][0];
                    int next_c = p.y + delta[j][1];

                    if(next_r < 0 || next_r >= arr.length || next_c < 0 || next_c >= arr[0].length || arr[next_r][next_c] != 0) continue;

                    arr[next_r][next_c] = 1;
                    queue.offer(new Point(next_r, next_c));
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 0){
                    count = 0;
                    break;
                }
            }
        }

        bw.write((count - 1) + "");
        bw.close();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(arr);
    }
}