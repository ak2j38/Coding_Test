import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    public static void main(String[] args) {
        try {
            input();
            // dfs 탐색
            dfs(V);
            sb.append("\n");
            // visit 배열 초기화
            for(int i=1; i<=N; i++) visit[i] = false;
            // bfs 탐색
            bfs(V);
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int v){
        // v를 방문했다.
        visit[v] = true;
        sb.append(v).append(" ");

        // v에서 갈 수 있는 곳들을 작은 번호부터 모두 방문한다.
        for(int i=1; i<=N; i++){
            if(adj[v][i] == 0) continue;

            // i를 이미 갈 수 있다는 사실을 안다면, 굳이 갈 필요 없음
            if(visit[i]) continue;

            // y에서 갈 수 있는 곳들도 확인
            dfs(i);
        }
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;

        while(!que.isEmpty()){
            int x = que.poll();
            sb.append(x).append(" ");

            for(int i=1; i<=N; i++){
                if(adj[x][i] == 0) continue;
                if(visit[i]) continue;

                que.add(i);
                visit[i] = true;
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
        adj = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i=0; i<M; i++){
            split = br.readLine().split(" ");
            adj[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 1;
            adj[Integer.parseInt(split[1])][Integer.parseInt(split[0])] = 1;
        }
    }
}
