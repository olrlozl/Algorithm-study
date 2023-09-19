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

    public static int prim(int start, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];
        int total = 0;

        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if(visit[edge.v]) continue;

            visit[edge.v] = true;
            total += edge.cost;

            for(Edge e : graph[edge.v]) {
                if(!visit[e.v]) {
                    pq.offer(e);
                }
            }
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];

        for(int i = 0; i < v + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        bw.write(prim(1, v) + "");
        bw.close();
    }
}