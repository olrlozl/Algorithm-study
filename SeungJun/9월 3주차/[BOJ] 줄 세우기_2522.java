import java.util.*;
import java.io.*;

public class Main {
    public static void topoSort(ArrayList<Integer>[] graph, int[] edgeCount) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < edgeCount.length; i++) {
            if(edgeCount[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            bw.write(now + " ");

            for(int next : graph[now]) {
                edgeCount[next]--;

                if(edgeCount[next] == 0) {
                    queue.add(next);
                }
            }
        }

        bw.close();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] edgeCount = new int[n + 1];

        for(int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            edgeCount[b]++;
        }

        topoSort(graph, edgeCount);
    }
}