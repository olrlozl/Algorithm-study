// 실패

import java.util.Comparator;
import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] fatigue = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int rest = minerals.length%5;
        int n = (minerals.length-rest)/5;;
        if(rest > 0) {
            n += 1;
        } 
        boolean[][] check = new boolean [n][5];
        int[][] ore = new int[n][3];
        for(int i = 0; i < minerals.length; i+=5) {
            int idx = 0;
            for(int j = i; j < i+5; j++) {
                if(j < minerals.length) {
                    check[idx][j] = true;
                    switch(minerals[j]) {
                        case "diamond":
                            ore[idx][0]++;
                            break;
                        case "iron":
                            ore[idx][1]++;
                            break;
                        case "stone":
                            ore[idx][2]++;
                            break;
                    }
                }
            }
            idx++;
        }
        // Arrays.sort(ore, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[]o2) {
        //         return o2[0]-o1[0];
        //     }
        // });
        Arrays.sort(ore, Comparator.comparingInt((int[] o) -> o[0]).reversed());
        int cnt = 0;
        if(picks[0] > 0) {
            for(int d = 0; d < picks[0]; d++) {
                answer += 1*ore[cnt][0];
                answer += 1*ore[cnt][1];
                answer += 1*ore[cnt][2];
                cnt++;
            }
        }
        if(picks[1] > 0) {
            for(int i = 0; i < picks[1]; i++) {
                answer += 5*ore[cnt][0];
                answer += 1*ore[cnt][1];
                answer += 1*ore[cnt][2];
                cnt++;
            }
        }
        if(picks[2] > 0) {
            for(int s = 0; s < picks[2]; s++) {
                answer += 25*ore[cnt][0];
                answer += 5*ore[cnt][1];
                answer += 1*ore[cnt][2];
                cnt++;
            }
        }
        return answer;
    }
}
