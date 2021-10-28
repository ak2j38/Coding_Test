import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, start, find, answer;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static boolean flag;
    static int[] dist;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;
        dist[start] = 0;

        while(!que.isEmpty()){
            if(flag) break;
            int x = que.poll();
            for(int y : adj[x]){
                // 찾아야되는 수 발견!
                if(y == find) flag = true;

                if(visit[y]) continue;

                que.add(y);
                visit[y] = true;
                dist[y] = dist[x]+1;
            }
        }
    }

    static void solve(){
        answer = 0; flag = false;
        // 촌수 배열 초기화
        for(int i=0; i<=N; i++) dist[i] = -1;
        bfs(start);
        System.out.println(dist[find]);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        start = Integer.parseInt(split[0]);
        find = Integer.parseInt(split[1]);
        M = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        visit = new boolean[N+1];
        dist = new int[N+1];
        for(int i=0; i<=N; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<M; i++){
            split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            adj[x].add(y);
            adj[y].add(x);
        }
    }
}
