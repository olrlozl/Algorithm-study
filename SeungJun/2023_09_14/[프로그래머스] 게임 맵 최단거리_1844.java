import java.util.*;
import java.awt.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        int[][] d_value = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int n = maps.length, m = maps[0].length;

        queue.offer(new Point(0, 0));

        while(!queue.isEmpty()){
            Point p = queue.poll();
            int r = p.x;
            int c = p.y;

            for(int[] arr : d_value){
                int next_r = r + arr[0];
                int next_c = c + arr[1];
                if(0 <= next_r && next_r < n && 0 <= next_c && next_c < m && maps[next_r][next_c] == 1){
                    maps[next_r][next_c] = maps[r][c] + 1;
                    queue.offer(new Point(next_r, next_c));
                }
            }
        }

        if(maps[n - 1][m - 1] == 1) return -1;
        else return maps[n - 1][m - 1];
    }
}