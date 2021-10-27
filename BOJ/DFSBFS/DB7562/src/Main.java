import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int T, N;
    static int[][] adj, knights, dir = {{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
    static boolean[][] visit;

    public static void main(String[] args) {
        try {
            input();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs(){
        Queue<Integer> que = new LinkedList<>();

        // 시작점 큐에 넣어주기
        que.add(knights[0][0]);
        que.add(knights[0][1]);
        visit[knights[0][0]][knights[0][1]] = true;

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();

            for(int k=0; k<8; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny]) continue;

                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
                adj[nx][ny] = adj[x][y] + 1;
            }
        }
    }

    static void solve(){
        bfs();
        System.out.println(adj[knights[1][0]][knights[1][1]]);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            visit = new boolean[N][N];
            adj = new int[N][N];
            knights = new int[2][2];
            for(int j=0; j<2; j++){
                String[] split = br.readLine().split(" ");
                knights[j][0] = Integer.parseInt(split[0]);
                knights[j][1] = Integer.parseInt(split[1]);
            }
            solve();
        }
    }
}
