package 소수찾기;

class Solution {
	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(5));
	}
	
    public static int solution(int n) {
        int answer = n-1;
        boolean[] nums = new boolean[n+1];
        for(int i = 2; i <= n; i++) {
        	if(nums[i] == true) continue;
        	for(int j = i*2; j <= n; j+=i) {
        		if(j%i == 0 && !nums[j]) {
        			nums[j] = true;
        			answer--;
        		}
        	}
        }
        return answer;
    }
}