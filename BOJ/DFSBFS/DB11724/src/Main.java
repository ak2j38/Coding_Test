import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> answers;
    static int N, M, answer;
    static int[][] adj;
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
        for(int i=0; i<N; i++){
            if(visit[x][i]) continue;
            // 재귀호출
            dfs(x, i);
        }
    }

    static void solve(){
        answers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!visit[i][0] && adj[i][0] == 1) {
                dfs(i, 0);
                answer++;
            }
        }
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
