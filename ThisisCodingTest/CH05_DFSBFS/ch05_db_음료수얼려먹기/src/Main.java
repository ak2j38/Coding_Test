import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static int N, M;
    static int[][] adj, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visited;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        int iceCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (adj[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j);
                    iceCnt++;
                }
            }
        }
        System.out.println(iceCnt);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int k=0; k<4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (adj[nx][ny] == 1) continue;
            if (visited[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        adj = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                adj[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
