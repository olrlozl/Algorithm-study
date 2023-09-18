import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] visit;

    public static int bfs(ArrayList<Integer>[] list, int start, int count){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int v : list[now]){
                if(!visit[v]){
                    queue.offer(v);
                    visit[v] = true;
                    count++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visit = new boolean[n + 1];

        ArrayList<Integer>[] list = new ArrayList[n + 1];

        for(int i = 0; i < n + 1; i++) list[i] = new ArrayList<Integer>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);

        }

        bw.write("" + bfs(list, 1, 0));
        bw.close();
    }
}