import java.util.*;

class Solution {
    public int bfs(int storey) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[100000001];

        queue.add(storey);
        visit[storey] = 1;

        loop: while (!queue.isEmpty()) {
            int now = queue.poll();
            int copy_now = now;

            for(int i = 0;; i++) {
                if(copy_now % 10 == 0) {
                    copy_now /= 10;
                    continue;
                }

                int minus = now - (int)Math.pow(10, i);
                int plus = now + (int)Math.pow(10, i);

                if(minus >= 0 && visit[minus] == 0) {
                    visit[minus] = visit[now] + 1;
                    queue.add(minus);

                    if(minus == 0) break loop;
                }

                if(plus <= 100000000 && visit[plus] == 0) {
                    visit[plus] = visit[now] + 1;
                    queue.add(plus);
                }

                break;
            }
        }

        return visit[0] - 1;
    }
    public int solution(int storey) {
        return bfs(storey);
    }
}