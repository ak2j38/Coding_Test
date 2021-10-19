import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> answers;
    static int N, M, answer;
    static int[][] adj, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        for(int k=0; k<4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            // 범위확인
            if(nx < 0 || ny < 0 || nx>=N || ny>=N) continue;
            // 값 확인
            if(adj[nx][ny] == 0) continue;
            // 방문여부확인
            if(visit[nx][ny]) continue;
            // 재귀호출
            dfs(nx, ny);
        }
    }

    static void solve(){
        answers = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j] && adj[i][j] == 1){
                    dfs(i, j);
                    answer++;
                }
            }
        }
//        System.out.println(answers.size());
        System.out.println(answer);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        adj = new int[N][N];
        visit = new boolean[N][N];
        for(int i=0; i<M; i++){
            split = br.readLine().split(" ");
            adj[Integer.parseInt(split[0])-1][Integer.parseInt(split[1])-1] = 1;
            adj[Integer.parseInt(split[1])-1][Integer.parseInt(split[0])-1] = 1;
        }
    }
}
