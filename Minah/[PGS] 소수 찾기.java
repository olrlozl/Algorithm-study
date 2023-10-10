// 실패. 시간초과

import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> prime = new ArrayList<>();
		int answer = 0;
		if(n == 2)
			return 1;
		prime.add(2);
		for(int num = 3; num <= n; num++) {
			int cnt = 0;
			for(int d = 2; d <= num; d++) {
				if(d < num && num%d == 0) {
					break;
				} else if(num == d && num%d == 0){
					cnt++;
				}
			}
			if(cnt == 1) {
				prime.add(num);
			}
		}
		return prime.size();
    }
}
