import java.util.PriorityQueue;

public class Solution {
	public int solution(int[] arrayA, int[] arrayB) {
        
        PriorityQueue<Integer> PQA = new PriorityQueue<>();
        for(int a : arrayA) PQA.offer(a);
        PriorityQueue<Integer> PQB = new PriorityQueue<>();
        for(int b : arrayB) PQB.offer(b);
        
        int A = caseCheck(PQA.peek(), arrayA, arrayB); // 철수 카드 확인
        int B = caseCheck(PQB.peek(), arrayB, arrayA); // 영희 카드 확인
        
        return Math.max(A, B);
    }
	
	public int caseCheck(int key, int[] mine, int[] others) {
		// 가진 카드의 모든 숫자를 나눌 수 있는가
		key = GCD(key, mine);
		if(key == 0) return 0;
		for(int card : others) { // 남의 카드는 모든 숫자를 나눌 수 없는가
			if(card%key == 0) return 0;
		}
		return key;
	}
	
	public int GCD(int key, int[] cards) {
		for(int i = key; i > 1; i--) {
			for(int j = 0; j < cards.length; j++) {
				if(cards[j]%i != 0) break;
				if(j == cards.length-1) return i;
			}
		}
		return 0;
	}
}
