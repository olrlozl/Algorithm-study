import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        int answer = 0;

        set.add(arrayA[0]);
        set.add(arrayB[0]);

        for(int i = 2; i <= Math.max(Math.sqrt(arrayA[0]), Math.sqrt(arrayB[0])); i++) {
            if(arrayA[0] % i == 0) {
                set.add(i);
                set.add(arrayA[0] / i);
            }

            if(arrayB[0] % i == 0) {
                set.add(i);
                set.add(arrayB[0] / i);
            }
        }

        loop: for(int num : set) {
            if(arrayA[0] % num == 0 && arrayB[0] % num == 0) continue;

            for(int i = 1; i < arrayA.length; i++) {
                if((arrayA[i] % num == 0 && arrayB[i] % num == 0) || (arrayA[0] % num == 0 && arrayA[i] % num != 0) || (arrayB[0] % num == 0 && arrayB[i] % num != 0)) continue loop;
            }

            answer = num;
            break;
        }

        return answer;
    }
}