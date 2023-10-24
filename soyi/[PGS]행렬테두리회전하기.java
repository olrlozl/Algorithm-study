class Solution {
	public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static int[] solution(int row, int col, int[][] queries) {
		int[][] arr = new int[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				arr[i][j] = i*col + j + 1;
			}
		}
		int[] answer = new int[queries.length];
		for(int q = 0; q < queries.length; q++) {
			int x1 = queries[q][0]-1; int y1 = queries[q][1]-1;
			int x2 = queries[q][2]-1; int y2 = queries[q][3]-1;
			int i = x1; int j = y1;
			int tmp1 = arr[i][j]; int tmp2 = arr[i][j];
			int idx = 0;
			int mini = arr[i][j];
			boolean[][] vis = new boolean[row][col];
			me : do {
				vis[i][j] = true;
				tmp1 = tmp2;
				mini = Integer.min(mini, tmp1);
				while(i+dir[idx][0] < x1 || i+dir[idx][0] > x2 || j+dir[idx][1] < y1 || j+dir[idx][1] > y2) {
					idx += 1;
					if(idx == 4) break me;
				}
				if(vis[i+dir[idx][0]][j+dir[idx][1]]) break me;
				tmp2 = arr[i+dir[idx][0]][j+dir[idx][1]];
				arr[i+dir[idx][0]][j+dir[idx][1]] = tmp1;
				i += dir[idx][0];
				j += dir[idx][1];
			}while(!(i == x1 && j == y1));
			arr[x1][y1] = tmp1;
			answer[q] = mini;
		}
        return answer;
    }
}
