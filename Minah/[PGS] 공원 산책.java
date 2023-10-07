// 성공
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = new int[2]; //시작위치 넣을 배열 => 답

        // E, S, W, N : 우, 하, 좌, 상
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int parkR = park.length; // park 세로길이
        int parkC = park[0].length(); // park 가로길이
        int[][] parkCopy = new int[parkR][parkC];
        for(int row = 0; row < parkR; row++) {
            for(int col = 0; col < parkC; col++) {
                if(park[row].charAt(col) == 'S') {
                    parkCopy[row][col] = 2; //시작위치
                    start[0] = row;
                    start[1] = col;
                } else if(park[row].charAt(col) == 'O') {
                    parkCopy[row][col] = 0; //이동 가능
                } else {
                    parkCopy[row][col] = 1; //장애물
                }
            }
        } // park배열 값 int로 담아서 parkCopy에 넣어주기.
        
        String[][] routesCopy = new String[routes.length][2];
        for(int i = 0; i < routes.length; i++) {
            routesCopy[i] = routes[i].split(" ");
        } // routes배열 '이동할 방향'과 '이동할 칸의 수'로 나눠주기
        
        // 명령 수행
        for(int i = 0; i < routes.length; i++) {
            int n = Integer.parseInt(routesCopy[i][1]);
            int cnt = 0;
            int[] tmp = {start[0], start[1]};
            switch(routesCopy[i][0]) {
                case "E" :
                    // 이동할 수만큼 반복
                    while(cnt < n) {
                        int nc = tmp[1]+dir[0][1];
                        if (nc < parkC && parkCopy[start[0]][nc] != 1) {
                            tmp[1] = nc;
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    // 명령의 수만큼 수행했다면 시작 위치 바꿔주기 
                    if(cnt == n) {
                        start[1] = tmp[1];
                    }
                    break;
                case "S" :
                    while(cnt < n) {
                        int nr = tmp[0]+dir[1][0];
                        if (nr < parkR && parkCopy[nr][start[1]] != 1) {
                            tmp[0] = nr;
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    if(cnt == n) {
                        start[0] = tmp[0];
                    }
                    break;
                case "W" :
                    while(cnt < n) {
                        int nc = tmp[1]+dir[2][1];
                        if (0 <= nc && parkCopy[start[0]][nc] != 1) {
                            tmp[1] = nc;
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    if(cnt == n) {
                        start[1] = tmp[1];
                    }
                    break;
                case "N" :
                    while(cnt < n) {
                        int nr = tmp[0]+dir[3][0];
                        if (0 <= nr && parkCopy[nr][start[1]] != 1) {
                            tmp[0] = nr;
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    if(cnt == n) {
                        start[0] = tmp[0];
                    }
                    break;
            }
        }
        return start;
	}
}
