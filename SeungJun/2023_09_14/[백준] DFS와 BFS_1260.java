import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;
    public static void set(int n) {
        visited = new boolean[n + 1];
        arr = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) arr[i] = new ArrayList<Integer>();
    }
    public static void dfs(int v){
        visited[v] = true;

        System.out.printf("%d ", v);

        for(int i : arr[v]) if (!visited[i]) dfs(i);
    }
    public static void bfs(int v){
        visited = new boolean[visited.length];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);

        visited[v] = true;

        while(!queue.isEmpty()){
            int idx = queue.poll();
            System.out.printf("%d ", idx);

            for(int i : arr[idx]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }

        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        set(n);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());

            arr[idx1].add(idx2);
            arr[idx2].add(idx1);
        }

        for(int i = 0; i < n + 1; i++) arr[i].sort(Comparator.naturalOrder());

        dfs(v);
        System.out.println();
        bfs(v);

    }
}
