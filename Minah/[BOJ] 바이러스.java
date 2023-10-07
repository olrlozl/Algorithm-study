//성공

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int node = sc.nextInt();
		int[][] adjArr = new int[node+1][node+1]; 
		int edge = sc.nextInt();
		for(int e = 0; e < edge; e++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjArr[a][b] = adjArr[b][a] = 1;
		}
		
		boolean[] check = new boolean[node+1];
		int[] cnt = new int[1];
		
		dfs(adjArr, check, node, cnt, 1);
		
		int answer = cnt[0]-1;
		
		System.out.println(answer);
	}
	
	public static void dfs(int[][] adjArr, boolean[] check, int node, int[] cnt, int start) {
		check[start] = true;
		cnt[0]++;
		
		for(int n = 0; n <= node; n++) {
			if(adjArr[start][n] == 1 && !check[n]) {
				dfs(adjArr, check, node, cnt, n);
			}
		}
	}
}
