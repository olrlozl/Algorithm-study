import java.util.*;

class Solution {
    public int answer = Integer.MAX_VALUE;
    public int[][] fatigability = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    public Map<String, Integer> map = new HashMap<String, Integer>(){{
        put("diamond", 0); put("iron", 1); put("stone", 2);
    }};

    public int working(int[] pickax, String[] minerals) {
        int total = 0;

        loop: for(int i = 0, idx = 0; i < pickax.length; i++) {
            for(int j = 0; j < 5; j++) {
                if(idx == minerals.length || total >= answer) break loop;

                total+= fatigability[pickax[i]][map.get(minerals[idx++])];
            }
        }

        return total;
    }
    public void permutation(int[] pickax, String[] minerals, int depth) {
        if(depth == pickax.length) {
            answer = Math.min(answer, working(pickax, minerals));
            return;
        }

        boolean[] visit = new boolean[3];

        for(int i = depth; i < pickax.length; i++) {
            if(!visit[pickax[i]]) {
                visit[pickax[i]] = true;
                swap(pickax, depth, i);
                permutation(pickax, minerals, depth + 1);
                swap(pickax, depth, i);
            }
        }
    }
    public void swap(int[] picks, int idx1, int idx2) {
        int tmp = picks[idx1];
        picks[idx1] = picks[idx2];
        picks[idx2] = tmp;
    }
    public int solution(int[] picks, String[] minerals) {
        int total = picks[0] + picks[1] + picks[2];
        int[] pickax = new int[total];

        for(int i = 0, idx = 0; i < 3; i++) {
            for(int j = 0; j < picks[i]; j++) {
                pickax[idx++] = i;
            }
        }

        permutation(pickax, minerals, 0);

        return answer;
    }
}