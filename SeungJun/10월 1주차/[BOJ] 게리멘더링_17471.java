import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static int[] person;
    static int min = Integer.MAX_VALUE;

    public static void bfs(boolean[] select, boolean[] visit, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean standard = select[start];

        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int v : graph[now]) {
                if(!visit[v] && standard == select[v]) {
                    queue.offer(v);
                    visit[v] = true;
                }
            }
        }
    }

    public static void combination(boolean[] select, int idx, int n, int count) {
        if(count == n) {
            boolean[] visit = new boolean[select.length + 1];
            int cnt = 0;

            for(int i = 1; i < select.length; i++) {
                if(!visit[i]) {
                    bfs(select, visit, i);
                    cnt++;
                }
            }

            if(cnt == 2) {
                int total = 0;

                for(int i = 1; i < select.length; i++) {
                    if(select[i]) total += person[i];
                    else total -= person[i];
                }

                min = Math.min(min, Math.abs(total));
            }

            return;
        }
        else if(idx == select.length) {
            return;
        }

        select[idx] = true;
        combination(select, idx + 1, n, count + 1);
        select[idx] = false;
        combination(select ,idx + 1, n, count);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        person = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            person[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for(int j = 0; j < num; j++) graph[i].add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 1; i <= n / 2 + n % 2; i++) {
            boolean[] select = new boolean[n + 1];

            combination(select, 0, i, 0);
        }

        if(min == Integer.MAX_VALUE) min = -1;

        bw.write(min + "");
        bw.close();
    }
}