import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, min, answer;
    static int[][] adj, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs(){
        Queue<Integer> que = new LinkedList<>();

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(adj[i][j] == 1){
                    que.add(i);
                    que.add(j);
                    visit[i][j] = true;
                }
            }
        }

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();

            for(int k=0; k<4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                // 구간 확인
                if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
                // 방문확인
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

        // 각 줄을 돌면서 자신을 제외하고 더한 합이 가장 작은 사람을 저장
        for(int i=1; i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++){
                // 자기 자신은 합계제외
                if(i != j) sum += adj[i][j];

            }
            // 현재 합계가 지금까지의 최솟값과 같지않다면 최솟값 갱신
            if(sum < min) {
                min = Math.min(min, sum);
                answer = i;
            }
        }
        System.out.println(answer);
    }

    static void print(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                System.out.print(adj[i][j]);
            }
            System.out.println();
        }
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        min = Integer.MAX_VALUE;
        adj = new int[N+1][N+1];
        visit = new boolean[N+1][N+1];
        for(int i=0; i<M; i++){
            split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }
}
