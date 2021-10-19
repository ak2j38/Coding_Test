import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> answers = new ArrayList<>();
    static int T, N, M, K, answer;
    static int[][] adj, dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][] visit;

    public static void main(String[] args) {
        try {
            input();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int x, int y){
        answer++;
        visit[x][y] = true;
        for(int k=0; k<4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            // 범위확인
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            // 방문확인
            if(visit[nx][ny]) continue;
            // 값 확인
            if(adj[nx][ny] == 0) continue;
            // 재귀호출
            dfs(nx, ny);
        }
    }

    static void solve(){
        answers = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visit[i][j] && adj[i][j] == 1){
                    answer = 0;
                    dfs(i, j);
                    answers.add(answer);
                }
            }
        }
        System.out.println(answers.size());
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);
            K = Integer.parseInt(split[2]);

            adj = new int[N][M];
            visit = new boolean[N][M];

            for(int j=0; j<K; j++){
                split = br.readLine().split(" ");
                adj[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 1;
            }

            // 정답구하기
            solve();
        }
    }
}
