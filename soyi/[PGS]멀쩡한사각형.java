class Solution {
    public static long solution(int w, int h) {
        long answer = (long)w*h; // 전체 정사각형 개수
        int gcd = greatestCommonFactor(w, h); // 최대공약수 구하기
        int gw = w/gcd;
        int gh = h/gcd;
        long diagonal = cntDiagonal(gw, gh);
        answer -= diagonal*gcd;
//         anwer -= (gw+gh-1)*gcd;
        return answer;
    }
	
	public static int greatestCommonFactor(int w, int h) {
		int gcd = Integer.min(w, h);
		for(;gcd > 1; gcd--) {
			if(w%gcd == 0 && h%gcd == 0) return gcd;
		}
		return 1;
	}
	
	public static long cntDiagonal(int gw, int gh) {
		long cnt = 0;
		double len = (double)gh/gw;
		int start = 0;
		for(int i = 1; i <= gw; i++) {
			int end = (int) (len*i == (int)(len*i) ? len*i : len*i + 1);
			cnt += end-start;
			start = end-1;
		}
		System.out.println("cnt = " + cnt);
		return cnt;
	}
}
