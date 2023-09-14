package 비밀지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        // 1벽 0공백
        for(int i = 0; i < n; i++) {
            int tmp = arr1[i] | arr2[i];
            answer[i] = Integer.toBinaryString((1<<n) | tmp).substring(1).replace('1', '#').replace('0', ' ');
        }
        return answer;
    }
}