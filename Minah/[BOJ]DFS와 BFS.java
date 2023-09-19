package APS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class DFS_BFS {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //정점의 개수
		int m = sc.nextInt(); //간선의 개수
		int v = sc.nextInt(); //탐색을 시작할 정점의 번호
		
		//dfs
		List<Integer>[] adjList = new ArrayList[n+1];
		
		for(int i = 0; i < n+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i = 1; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adjList[x].add(y);
			adjList[y].add(x);
		}
		
		dfs(adjList, new boolean[n+1], v);
		
		System.out.println();
		
		//bfs
		boolean[] visited = new boolean[n+1];
		
		Queue<Integer> queue = new LinkedList<>();
			queue.add(v);
			
			visited[v] = true;
			
			while(!queue.isEmpty()) {
				int b = queue.poll();
				System.out.print(b+" ");
				
				for(int i : adjList[b]) {
					if(visited[i] == false) {
						queue.add(i);
						visited[i] = true;
					}
				}
			}
		
		sc.close();
	}
	
	public static void dfs(List<Integer>[] adjList, boolean[] visited, int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i : adjList[v]) {
			if(visited[i] == false) {
				dfs(adjList, visited, i);;
			}
		}
	}
}
