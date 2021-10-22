import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            dfs(V);
            sb.append("\n");
            visit = new boolean[N+1];
            bfs(V);
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int x){
        visit[x] = true;
        sb.append(x).append(" ");

        for(int y : adj[x]){
            if(visit[y]) continue;

            dfs(y);
        }
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;

        while (!que.isEmpty()){
            int x = que.poll();
            sb.append(x).append(" ");

            for(int y : adj[x]){
                if(visit[y]) continue;

                que.add(y);
                visit[y] = true;
            }
        }
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        V = Integer.parseInt(split[2]);

        adj = new ArrayList[N+1];
        visit = new boolean[N+1];

        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>(); // 여기서 1부터로 처리하지 않으면 밑에서 받는 값들의 조정이 필요해서 1로 처리
        for(int i=0; i<M; i++){
            split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            adj[x].add(y);
            adj[y].add(x);
        }
        for(int i=1; i<=N; i++){
            Collections.sort(adj[i]);
        }
    }
}
