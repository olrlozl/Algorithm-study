class Solution {
    public int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
    public long solution(int w, int h) {
        int gcd = gcd(w, h);
        long answer = ((long)w - 1) * ((long)h - 1) + gcd - 1;

        return answer;
    }
}