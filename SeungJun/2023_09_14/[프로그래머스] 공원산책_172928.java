class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        //현재 위치 찾기
        for(int i = 0; i < park.length; i++){
            if(park[i].contains("S")){
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
                break;
            }
        }

        //명령 수행

        for(String str : routes){
            String[] s = str.split(" ");
            int value = Integer.valueOf(s[1]);
            boolean ok = true;

            if(s[0].equals("E") && answer[1] + value < park[0].length()){
                for(int i = answer[1]; i <= answer[1] + value; i++) if(park[answer[0]].charAt(i) == 'X') ok = false;
                if(ok) answer[1] += value;
            }
            else if(s[0].equals("W") && answer[1] - value >= 0){
                for(int i = answer[1] - value; i <= answer[1]; i++) if(park[answer[0]].charAt(i) == 'X') ok = false;
                if(ok) answer[1] -= value;
            }
            else if(s[0].equals("S") && answer[0] + value < park.length){
                for(int i = answer[0]; i <= answer[0] + value; i++) if(park[i].charAt(answer[1]) == 'X') ok = false;
                if(ok) answer[0] += value;
            }
            else if(s[0].equals("N") && answer[0] - value >= 0){
                for(int i = answer[0] - value; i <= answer[0]; i++) if(park[i].charAt(answer[1]) == 'X') ok = false;
                if(ok) answer[0] -= value;
            }
        }


        return answer;
    }
}