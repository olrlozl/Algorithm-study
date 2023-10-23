class Solution {
    public int min = Integer.MAX_VALUE;
    public void dfs(String name, boolean[] check, int count, int idx, int answer) {
        answer += (name.charAt(idx) - 'A') > 13 ? 26 - (name.charAt(idx) - 'A') : (name.charAt(idx) - 'A');
        check[idx] = true;
        if(answer != 0) count++;

        if(count == check.length) {
            min = Math.min(min, answer);
            return;
        }

        int left = name.length() + idx - 1, right = idx + 1, len = 1;

        while (len < name.length() / 2 + 1) {
            if(!check[left % name.length()]) {
                dfs(name, check, count, left % name.length(), answer + len);
                check[left % name.length()] = false;
            }
            if(!check[right % name.length()]) {
                dfs(name, check, count, right % name.length(), answer + len);
                check[right % name.length()] = false;
            }

            left--;
            right++;
            len++;
        }
    }
    public int solution(String name) {
        boolean[] check = new boolean[name.length()];
        int count = 0;

        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == 'A') {
                check[i] = true;
                count++;
            }
        }

        dfs(name, check, count, 0, 0);

        return min;
    }
}