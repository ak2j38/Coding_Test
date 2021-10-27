import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N, M, answer;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        dfs(1);
        System.out.println(answer);
    }

    static void dfs(int start){
        visit[start] = true;

        for(int y : adj[start]){
            if(visit[y]) continue;

            answer++;
            dfs(y);
        }
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        answer = 0;
        adj = new ArrayList[N+1];
        visit = new boolean[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
        for(int i=1; i<=M; i++){
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            adj[x].add(y);
            adj[y].add(x);
        }
    }
}
