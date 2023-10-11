package 게리맨더링;

import java.util.Scanner;

public class Main {
    public static int N;
    public static int[] ppl;
    public static boolean[][] contact;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력
        N = scanner.nextInt(); // 구역의 개수
        ppl = new int[N]; // 각 구역의 인구 수
        for(int i = 0; i < N; i++){
            ppl[i] = scanner.nextInt();
        }
        contact = new boolean[N][N];
        for(int i = 0; i < N; i++){
            int cnt = scanner.nextInt(); // 인접 구역 개수
            for(int j = 0; j < cnt; j++){
                int dis = scanner.nextInt()-1;
                contact[i][dis] = true;
                contact[dis][i] = true;
            }
        }
        // 계산
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i < (1<<N)-1; i++){ // 구역을 둘로 나누는 모든 경우
            // 두 구역이 모두 연결 되어 있는지 확인
            String choose = Integer.toBinaryString((1<<N) | i).substring(1);
            boolean[] vis = new boolean[N];
            boolean flag = true;
            int start0 = -1;
            int start1 = -1;
            for(int j = 0; j < N; j++){
                if(start0 == -1 && choose.charAt(j) == '0') {
                    start0 = j;
                    vis[start0] = true;
                    ValidCheck(0, start0, vis, choose);
                }
                if(start1== -1 && choose.charAt(j) == '1') {
                    start1 = j;
                    vis[start1] = true;
                    ValidCheck(1, start1, vis, choose);
                }
            }
            for(int check = 0; check < N; check++){
                if(!vis[check]) {
                    flag = false;
                    break;
                }
            }
            // 두 구역의 인구 수 차이 구하기
            if(flag){
                answer = Integer.min(answer, diffCheck(choose));
            }
        }
        // 출력
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
        scanner.close();
    }

    public static void ValidCheck(int dis, int cur, boolean[] vis, String choose){
        for(int i = 0; i < N; i++){
            if(contact[cur][i] && !vis[i] && choose.charAt(i)-'0' == dis){
                vis[i] = true;
                ValidCheck(dis, i, vis, choose);
            }
        }
    }

    public static int diffCheck(String a){
        int total = 0;
        for(int i = 0; i < N; i++){
            if(a.charAt(i) == '0'){ // 0구역의 합
                total += ppl[i];
            } else { // 1구역의 합
                total -= ppl[i];
            }
        }
        return Math.abs(total);
    }
}
