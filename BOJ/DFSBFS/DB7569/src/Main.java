import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, H, answer;
    static int[][][] adj, dist, dir = {{{1,0,0},{0,1,0},{-1,0,0},{0,-1,0},{0,0,-1},{0,0,1}}};
    static boolean[][][] visit;
    static boolean flag;

    public static void main(String[] args) {
        try {
            input();
            solve();
            check();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs(){
        Queue<Integer> que = new LinkedList<>();

        // 큐에 토마토 좌표 넣기
        for(int i=0; i<H; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<N; k++){
                    // 익은 토마토라면
                    if(adj[i][j][k] == 1){
                        que.add(j); // 가로
                        que.add(k); // 세로
                        que.add(i); // 높이
                        visit[i][j][k] = true; // 방문체크
                    }
                }
            }
        }

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();
            int h = que.poll();

            for(int k=0; k<6; k++){
                int nx = x + dir[0][k][1];
                int ny = y + dir[0][k][2];
                int nh = h + dir[0][k][0];

                // 유효성 검사
                if(nx < 0 || ny < 0 || nh < 0 || nx >= M || ny >= N || nh >= H) continue;
                // 값 체크(익지 않은 토마토가 아니면 패스) - 여기서 값 셋팅이 필요한가?
                if(adj[nh][nx][ny] != 0) continue;
                // 방문체크
                if(visit[nh][nx][ny]) continue;

                que.add(nx);
                que.add(ny);
                que.add(nh);
                visit[nh][nx][ny] = true;

                dist[nh][nx][ny] = dist[h][x][y] + 1;
            }
        }
    }

    static void solve(){
        bfs();

    }

    static void check(){
        // 기존 adj 배열에서도 0이고 bfs가 끝난 dist 배열에서도 0인 값이 있으면 -1 출력해야됨
        // 그런 값이 없다면 배열중 최댓값 출력
        for(int i=0; i<H; i++){
            if(flag) break;
            for(int j=0; j<M; j++){
                if(flag) break;
                for(int k=0; k<N; k++){
                    if(adj[i][j][k] == 0 && dist[i][j][k] == 0){
                        answer = -1;
                        flag = true;
                        break;
                    }else{
                        answer = Math.max(answer, dist[i][j][k]);
                    }
                }
            }
        }
    }

    static void print(){
        System.out.println(answer);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]); // 열
        M = Integer.parseInt(split[1]); // 행
        H = Integer.parseInt(split[2]); // 면
        adj = new int[H][M][N];
        dist = new int[H][M][N];
        visit = new boolean[H][M][N];
        answer = Integer.MIN_VALUE;
        // 높이
        for(int h=0; h<H; h++){
            // 가로
            for(int i=0; i<M; i++){
                split = br.readLine().split(" ");
                // 세로
                for(int j=0; j<N; j++){
                    adj[h][i][j] = Integer.parseInt(split[j]);
                }
            }
        }
    }
}
