import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
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

    static void bfs(int rainHeight, Queue<Integer> que){
        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();
            visit[x][y] = true;

            for(int k=0; k<4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(adj[nx][ny] < rainHeight) continue;
                if(visit[nx][ny]) continue;

                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
            }
            cnt++;
        }
®        answer = Math.max(answer, cnt);
    }

    static void solve(){
        // 안전지역에서 시작해야한다....
        // 물높이에 따라 bfs 실행해야함
        Queue<Integer> que = new LinkedList<>();

        for(int rainHeight=0; rainHeight<=maxRain; rainHeight++){
            isSafePosition(rainHeight, que);
            bfs(rainHeight, que);
            visit = new boolean[N][N];
            cnt = 0;
        }
        System.out.println(answer);
    }

    static void isSafePosition(int rainHeight, Queue<Integer> que) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(adj[i][j] >= rainHeight){
                    que.add(i);
                    que.add(j);
                }
            }
        }
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
