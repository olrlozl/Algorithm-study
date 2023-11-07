import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int weight_sum = 0, time = 0, idx = 0;

        for(int i = 0; i < bridge_length - 1; i++) queue.offer(0);

        do {
            if(idx >= truck_weights.length) {
                time += queue.size();
                break;
            }

            if(queue.size() == bridge_length) weight_sum -= queue.poll();

            if(weight_sum + truck_weights[idx] <= weight) {
                queue.offer(truck_weights[idx]);
                weight_sum += truck_weights[idx++];
            }
            else queue.offer(0);

            time++;
        } while(!queue.isEmpty());

        return time;
    }
}