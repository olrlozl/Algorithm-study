import java.util.*;

class Solution {
    public int answer = 0;
    public List<Integer> list = new ArrayList<>();;
    public void combination(String[][] relation, boolean[] selected, int r, int idx, int cnt) {
        if(cnt == r) {
            Set<String> set = new HashSet<>();
            int total = 0;

            for(int i = 0; i < selected.length; i++) {
                if(selected[i]) total += Math.pow(2, i);
            }

            for(int i = 0; i < list.size(); i++) {
                int num = list.get(i);

                if(((total ^ num) | total) == total) return;
            }

            for(int i = 0; i < relation.length; i++) {
                StringBuffer sb = new StringBuffer("");

                for(int j = 0; j < relation[0].length; j++) {
                    if(selected[j]) sb.append("-" + relation[i][j]);
                }

                if(set.contains(sb.toString())) return;

                set.add(sb.toString());
            }

            list.add(total);

            answer++;

            return;
        }
        else if(idx == selected.length) return;

        selected[idx] = true;
        combination(relation, selected, r, idx + 1, cnt + 1);

        selected[idx] = false;
        combination(relation, selected, r, idx + 1, cnt);
    }
    public int solution(String[][] relation) {
        for(int i = 1; i <= relation[0].length; i++) {
            combination(relation, new boolean[relation[0].length], i, 0, 0);
        }

        return answer;
    }
}