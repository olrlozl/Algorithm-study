import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int answer = enemy.length;

        for(int i = 0; i < enemy.length; i++) {
            n -= enemy[i];

            pq.add(enemy[i]);

            if (n < 0) {
                if (k <= 0) {
                    answer = i;
                    break;
                } else {
                    k--;
                    n += pq.poll();
                }
            }
        }

        return answer;
    }
}