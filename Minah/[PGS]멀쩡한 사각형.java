class Solution {
    public long solution(int w, int h) {
        long copyW = (long)w;
        long copyH = (long)h;
        // 최대공약수
        long gcdValue = gcd(copyW, copyH);
        //전체 사각형 개수 - 사용할 수 없는 사각형 개수
        long answer = copyW*copyH - (((copyW/gcdValue)+(copyH/gcdValue)-1)*gcdValue);
        return answer;
    }
    public static long gcd(long a, long b) {
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
}
