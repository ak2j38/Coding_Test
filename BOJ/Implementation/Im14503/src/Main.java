import java.io.*;

public class Main {
    static int N, M, ANSWER;
    static int[][] adj, dir = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] visited;
    static RobotCleaner rc;

    static class RobotCleaner {
        int r, c, d;

        public RobotCleaner(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {
        System.out.println(ANSWER);
    }

    static void solve() {
        dfs(rc.r, rc.c, rc.d);
    }

    static void dfs(int r, int c, int d) {
        // 벽이면 리턴
        if (adj[r][c] == 1) {
            return;
        } else if(!visited[r][c]) {
            // 방문 체크와 청소구역 갱신
            visited[r][c] = true;
            ANSWER++;
        }

        for (int k=0; k<4; k++) {
            d = (d+3)%4;
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            // 범위판단
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            // 벽 판단
            if (adj[nr][nc] == 1) continue;
            // 방문 판단(청소여부)
            if (visited[nr][nc]) continue;

            dfs(nr, nc, d);
            return;
        }
        // 뒤로 후진
        dfs(r-dir[d][0], c-dir[d][1], d);
        return;
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        ANSWER = 0;
        adj = new int[N][M];
        visited = new boolean[N][M];
        split = br.readLine().split(" ");
        rc = new RobotCleaner(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        for (int i=0; i<N; i++) {
            split = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                adj[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
