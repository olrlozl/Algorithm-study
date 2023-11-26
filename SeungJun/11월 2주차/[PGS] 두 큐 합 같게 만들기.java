import java.util.*;

class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> queue_1 = new LinkedList<>();
        Queue<Integer> queue_2 = new LinkedList<>();
        int answer = 0;
        long sum1 = 0, sum2 = 0;

        for(int i = 0; i < queue1.length; i++) {
            queue_1.offer(queue1[i]);
            queue_2.offer(queue2[i]);

            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        while(sum1 != sum2) {
            if(answer > queue1.length * 3) {
                answer = -1;
                break;
            }

            if(sum1 > sum2) {
                int k = queue_1.poll();
                queue_2.offer(k);
                sum1 -= k;
                sum2 += k;
            }
            else {
                int k = queue_2.poll();
                queue_1.offer(k);
                sum1 += k;
                sum2 -= k;
            }

            answer++;
        }

        return answer;
    }
}