import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[][] adj, knight, enemy, dir = {{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            solve();
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs(){
        Queue<Integer> que = new LinkedList<>();

        que.add(knight[0][0]);
        que.add(knight[0][1]);
        visit[knight[0][0]][knight[0][1]] = true;

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
        for(int i=0; i<M; i++){
            sb.append(adj[enemy[i][0]][enemy[i][1]]).append(" ");
        }
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        enemy = new int[M][2];
        knight = new int[1][2];
        visit = new boolean[N][N];
        adj = new int[N][N];
        split = br.readLine().split(" ");
        knight[0][0] = Integer.parseInt(split[0])-1;
        knight[0][1] = Integer.parseInt(split[1])-1;
        for(int i=0; i<M; i++){
            split = br.readLine().split(" ");
            enemy[i][0] = Integer.parseInt(split[0])-1;
            enemy[i][1] = Integer.parseInt(split[1])-1;
        }
    }
}
