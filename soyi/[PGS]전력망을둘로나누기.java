package 전력망둘로나누기;

public class Solution {
    public static void main(String argc[]){
        int[][] w1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(solution(9, w1));
        int[][] w2 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution(4, w2));
        int[][] w3 = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        System.out.println(solution(7, w3));
    }

    public static int count;
    public static int solution(int n, int[][] wires) { // 송전탑 개수, 전선 정보
        int answer = Integer.MAX_VALUE;
        int[][] con = new int[n+1][n+1];
        for (int[] wire : wires) {
            con[wire[0]][wire[1]] = 1;
            con[wire[1]][wire[0]] = 1;
        }
        for (int[] wire : wires) { // 자를 전선 고르기
            // 자른 전선 0으로 변경
            con[wire[0]][wire[1]] = 0;
            con[wire[1]][wire[0]] = 0;
            // 1부터 연결된 송전탑 개수 세기
            count = 0;
            boolean[] vis = new boolean[n+1];
            vis[1] = true;
            countTower(con, vis, 1);
            // 송전탐 개수 차이 최소인 경우 갱신
            answer = Math.min(answer, Math.abs(count - (n - count)));
            // 자른 전선 1로 다시 연결
            con[wire[0]][wire[1]] = 1;
            con[wire[1]][wire[0]] = 1;
        }
        return answer;
    }

    public static void countTower(int[][] con, boolean[] vis, int key){
        for(int i = 1; i < con.length; i++){
            if(con[key][i] == 1 && !vis[i]){
                vis[i] = true;
                countTower(con, vis, i);
                vis[i] = false;
            }
        }
        count++;
    }
}