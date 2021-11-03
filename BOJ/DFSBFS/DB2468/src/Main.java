import java.io.*;

public class Main {
    // 가로세로, 최대강수량, 정답출력, 한번의 dfs를 실행했을 때의 안전지역의 수
    static int N, maxRain, answer, cnt;
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

    static void dfs(int x, int y, int rainHeight){
        visit[x][y] = true;

        for(int k=0; k<4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(adj[nx][ny] <= rainHeight) continue;
            if(visit[nx][ny]) continue;

            dfs(nx, ny, rainHeight);
        }
    }

    static void solve(){
        // dfs
        // 모든점에서 시작해본다(대신 조건을 만족해야하며, maxRain만큼의 반복도 필요하다;
        for(int rainHeight=0; rainHeight<=maxRain; rainHeight++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(adj[i][j] > rainHeight && !visit[i][j]){
                        dfs(i, j, rainHeight);
                        cnt++;
                    }
                }
            }
            // 여기가 강수량 단위마다 초기화되는 부분
            answer = Math.max(answer, cnt);
            visit = new boolean[N][N];
            cnt = 0;
        }
        System.out.println(answer);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        maxRain = Integer.MIN_VALUE;
        answer = Integer.MIN_VALUE;
        adj = new int[N][N];
        visit = new boolean[N][N];
        for(int i=0; i<N; i++){
            String[] split = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                adj[i][j] = Integer.parseInt(split[j]);
                maxRain = Math.max(maxRain, adj[i][j]);
            }
        }
    }
}
