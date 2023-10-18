import java.util.*;

class Solution {
    public int answer = 0;
    public boolean promising(Map<Character, Integer> map, String[] data){
        for(int i = 0; i < data.length; i++) {
            char op = data[i].charAt(3);
            int value = data[i].charAt(4) - '0';
            int gap = Math.abs(map.get(data[i].charAt(0)) - map.get(data[i].charAt(2))) - 1;

            if(op == '=' && gap != value) return false;
            else if(op == '>' && gap <= value) return false;
            else if(op == '<' && gap >= value) return false;
        }

        return true;
    }
    public void permutation(Map<Character, Integer> map, char[] kakao, boolean[] visit, String[] data, int idx) {
        if(idx == kakao.length) {
            if(promising(map, data)) answer++;
            return;
        }

        for(int i = 0; i < kakao.length; i++) {
            if(!visit[i]) {
                map.put(kakao[idx], i);
                visit[i] = true;
                permutation(map, kakao, visit, data, idx + 1);
                visit[i] = false;
            }
        }
    }
    public int solution(int n, String[] data) {
        Map<Character, Integer> map = new HashMap<>();
        char[] kakao = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

        permutation(map, kakao, new boolean[kakao.length], data, 0);

        return answer;
    }
}