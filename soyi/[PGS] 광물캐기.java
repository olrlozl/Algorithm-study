package 광물캐기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // 예제 1
        int[] p1 = {1, 3, 2}; // dia, iron, stone
        String[] m1 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(p1, m1));
        // 예제 2
        int[] p2 = {0, 1, 1};
        String[] m2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        System.out.println(solution(p2, m2));
    }

    public static int[][] hp = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    public static String[] mineral = {"diamond", "iron", "stone"};
    public static int[] turns;
    public static int answer;
    public static int solution(int[] picks, String[] minerals) { // 곡괭이 개수, 광물 순서
        answer = Integer.MAX_VALUE;
        // 사용할 곡괭이 순서 정하기
        turns = new int[picks[0] + picks[1] + picks[2]];
        makeTurn(picks, minerals, 0);
        return answer;
    }

    public static void makeTurn(int[] picks, String[] minerals, int lev){
        if(lev == turns.length){
            // 도구 출력
//            System.out.println(Arrays.toString(turns));
            // 광물 캐기
            int idx = 0;
            int tmp = 0;
            mine : for (int turn : turns) { // 곡괭이 들기
                for (int use = 0; use < 5; use++) { // 광물 5개 캐기
                    if (idx >= minerals.length) break mine;
                    tmp += hp[turn][Arrays.asList(mineral).indexOf(minerals[idx])];
                    idx++;
                }
            }
            answer = Integer.min(tmp, answer);
        }
        for(int i = 0; i < 3; i++){
            if(picks[i] == 0) continue;
            turns[lev] = i;
            picks[i]--;
            makeTurn(picks, minerals, lev+1);
            picks[i]++;
        }
    }
}
