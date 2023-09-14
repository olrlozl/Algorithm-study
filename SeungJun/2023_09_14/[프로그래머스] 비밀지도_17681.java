class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++){
            String str = Integer.toBinaryString(arr1[i] | arr2[i]);

            for(int j = 0; j < n - str.length();) str = "0" + str;

            String s = "";

            for(int j = 0; j < n; j++){
                if(str.charAt(j) == '0') s += " ";
                else s += "#";
            }

            answer[i] = s;
        }

        return answer;
    }
}