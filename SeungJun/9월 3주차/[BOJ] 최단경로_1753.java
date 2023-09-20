import java.util.*;
import java.io.*;

class Main {
    static List<Edge>[] graph;

    static class Edge implements Comparable<Edge> {
        int v;
        int cost;

        Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }

    public static void Dijkstra(int start) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[graph.length];
        int[] distance = new int[graph.length];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;

        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now_edge = pq.poll();

            if(visit[now_edge.v]) continue;

            visit[now_edge.v] = true;

            for(Edge next_edge : graph[now_edge.v]) {
                if(distance[next_edge.v] > distance[now_edge.v] + next_edge.cost) {
                    distance[next_edge.v] = distance[now_edge.v] + next_edge.cost;

                    pq.offer(new Edge(next_edge.v, distance[next_edge.v]));
                }
            }

        }

        for(int i = 1; i < distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(distance[i] + "\n");
        }

        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        graph = new ArrayList[v + 1];

        for(int i = 0; i < v + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
        }

        Dijkstra(k);
    }
}