import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, answer, B;
    static int[][] adj, blank, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int k, int selected_cnt){
        // 그 다음에 3개의 벽을 다 세우면 그 상태에서 bfs를 통해 어디까지 확산되는지(안전지역 갯수 체크)
        if(selected_cnt == 3){
            bfs();
            return;
        }
        // 더 이상 세울 벽이 없을 때
        if(k > B) return;

        adj[blank[k][0]][blank[k][1]] = 1;
        dfs(k+1, selected_cnt+1);
        adj[blank[k][0]][blank[k][1]] = 0;
        dfs(k+1, selected_cnt);
    }

    static void bfs(){
        // 사용할 큐 선언
        Queue<Integer> que = new LinkedList<>();

        // 모든점을 순회하면서 바이러스의 위치를 큐에 넣어놓는다(MultiSource BFS)
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                visit[i][j] = false;
                if(adj[i][j] == 2){
                    // 행, 열 순서로 넣어놓으면 뺄 때도 같은 순서로 빼서 사용 가능
                    que.add(i);
                    que.add(j);
                    visit[i][j] = true;
                }
            }
        }
        // 큐를 순회하면서 안전지역 갯수 체크
        while(!que.isEmpty()){
            int x = que.poll(), y = que.poll();
            for(int k=0; k<4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if(adj[nx][ny] != 0) continue;
                if(visit[nx][ny]) continue;

                visit[nx][ny] = true; // 바이러스 이동
                que.add(nx);
                que.add(ny);
            }
        }
        // answer값 갱신
        int cnt = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(adj[i][j] == 0 && !visit[i][j]) cnt++;
            }
        }
        answer = Math.max(answer, cnt);
    }

    static void solve(){
        // 벽을 세우기 위해 공간들의 위치를 미리 모아놓는다
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(adj[i][j] == 0){
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }

        // 먼저 dfs를 통해 3개의 벽을 세우는 것 처리
        dfs(1, 0);
        // 안전지역 갯수 출력(answer)
        System.out.println(answer);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        B = 0;
        answer = Integer.MIN_VALUE;
        adj = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];
        blank = new int[N*M+1][2];
        for(int i=1; i<=N; i++){
            split = br.readLine().split(" ");
            for(int j=1; j<=M; j++){
                adj[i][j] = Integer.parseInt(split[j-1]);
            }
        }
    }
}
