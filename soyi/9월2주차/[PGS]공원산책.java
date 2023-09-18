package 공원산책;

import java.awt.Point;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        // S 시작지점, O 통로, X 장애물
        // 공원 크기 확인
        int H = park.length; //
        int W = park[0].length();
        // 출발 지점 확인
        Point p = new Point();
        startPointCheck : for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    p.x = i;
                    p.y = j;
                    break startPointCheck;
                }
            }
        }
        // routes 확인
        for(int i = 0; i < routes.length; i++) {
            int move = routes[i].charAt(2) - '0';
            switch(routes[i].charAt(0)) {
                case 'N' : // 북쪽으로 이동
                    if(p.x - move >= 0) {
                        for(int m = 1; m <= move; m++) {
                            if(park[p.x-m].charAt(p.y) == 'X') break;
                            if(m==move) p.x -= move;
                        }
                    }
                    break;
                case 'S' : // 남쪽으로 이동
                    if(p.x + move < H) {
                        for(int m = 1; m <= move; m++) {
                            if(park[p.x+m].charAt(p.y) == 'X') break;
                            if(m==move) p.x += move;
                        }
                    }
                    break;
                case 'W' : // 서쪽으로 이동
                    if(p.y - move >= 0) {
                        for(int m = 1; m <= move; m++) {
                            if(park[p.x].charAt(p.y-m) == 'X') break;
                            if(m==move) p.y -= move;
                        }
                    }
                    break;
                case 'E' : // 동쪽으로 이동
                    if(p.y + move < W) {
                        for(int m = 1; m <= move; m++) {
                            if(park[p.x].charAt(p.y+m) == 'X') break;
                            if(m==move) p.y += move;
                        }
                    }
                    break;
            }
        }
        // 결과 출력
        int[] answer = {p.x, p.y};
        return answer;
    }
}