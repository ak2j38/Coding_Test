import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, answer;
    static int[][] adj, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;

    public static void main(String[] args) {
        try {
            input();
            bfs(0, 0);
            System.out.println(adj[N-1][M-1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs(int startx, int starty){
        Queue<Integer> que = new LinkedList<>();

        que.add(startx);
        que.add(starty);
        visit[startx][starty] = true;

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();

            for(int k=0; k<4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (adj[nx][ny] == 0) continue;
                if (visit[nx][ny]) continue;

                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
                adj[nx][ny] = adj[x][y]+1;
            }
        }
    }


    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        answer = 0;
        visit = new boolean[N][M];
        adj = new int[N][M];
        for(int i=0; i<N; i++){
            split = br.readLine().split("");
            for(int j=0; j<M; j++){
                adj[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
