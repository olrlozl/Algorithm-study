import java.util.*;

class Solution {
    public class Skill implements Comparable<Skill> {
		int idx; // 라운드
		int value; // 적의 수
		
		public Skill (int idx, int value) {
			this.idx = idx;
			this.value = value;
		}

		@Override
		public int compareTo(Skill o) {
			return this.value - o.value; // 오름차순 정렬
		}
	}
    
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Skill> pq = new PriorityQueue<>();
		int round = 0;
		
		// 무적권 스킬 있는대로 일단 다 쓰기
		for (int i = 0; i < Math.min(k, enemy.length); i++) { 
			pq.add(new Skill (i, enemy[i]));
			round++;
		}
		
		for (int i = k; i < enemy.length; i++) {
			if (Math.min(pq.peek().value, enemy[i]) <= n) { // 다음 라운드로 넘어갈 수 있다면
				if (pq.peek().value < enemy[i]) { // 무적권 스킬을 사용했던 라운드의 적 < 이번 라운드의 적
					n -= pq.poll().value;
					pq.add(new Skill(i, enemy[i]));
				}
				else { // 무적권 스킬을 사용했던 라운드의 적 >= 이번 라운드의 적
					n -= enemy[i];
				}
				round++;
			} else { // 다음 라운드로 넘어갈 수 없다면
				break;
			}
		}
		
		return round;
    }
}
