class Solution {
    public int solution(int storey) {
        int answer = 0;
        String strStorey = Integer.toString(storey);
        int[] sNums = new int[strStorey.length()];
        for(int i = 0; i < strStorey.length(); i++) {
            sNums[i] = strStorey.charAt(i) - '0';
        }
        for(int i = strStorey.length()-1; i >= 0; i--) {
            if(sNums[i] > 5) {
                if(sNums[i] == 10) {
                    if(i == 0) {
                        answer++;
                        continue;
                    }
                    sNums[i-1]++;
                    continue;
                } else {
                    answer += 10-sNums[i];
                    if(i == 0) {
                        answer++;
                        continue;
                    }
                    sNums[i-1]++;
                    continue;
                }
            } else if(sNums[i] == 5 && i > 0 && sNums[i-1] >= 5) {
                answer += 5;
                sNums[i-1]++;
                continue;
            } else {
                answer += sNums[i];
                continue;
            }
        }
        return answer;
    }
}
