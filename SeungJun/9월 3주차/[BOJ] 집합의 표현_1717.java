import java.util.*;
import java.io.*;

public class Main {
    public static void union(int[] parent, int a, int b){
        a = find(parent, a);
        b = find(parent, b);

        if(a == b) return;

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    public static int find(int[] parent, int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent, parent[a]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n + 1];

        for(int i = 1; i < n + 1; i++) parent[i] = i;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            if(Integer.parseInt(st.nextToken()) == 0) union(parent, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            else if(find(parent, Integer.parseInt(st.nextToken())) == find(parent, Integer.parseInt(st.nextToken()))) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.close();
    }
}