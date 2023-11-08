class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int N = truck_weights.length;
    		int[] timer = new int[N];
    		for(int i = 0; i < N; i++) timer[i] = bridge_length;
    		int front = 0;
    		int last = 0;
    		int onBridge = 0;
    		int answer = 0;
    		while(timer[N-1]!=0){
    			if(last < N && onBridge + truck_weights[last] <= weight) { // 다음 트럭이 다리 위로 올라갈 수 있는 경우
    				onBridge += truck_weights[last];
    				last++;
    			}
    			for(int on = front; on < last; on++) timer[on]--;
    			if(timer[front] == 0) {
    				onBridge -= truck_weights[front];
    				front++;
    			}
    			answer++;
    		}
        return answer+1;
    }
}
