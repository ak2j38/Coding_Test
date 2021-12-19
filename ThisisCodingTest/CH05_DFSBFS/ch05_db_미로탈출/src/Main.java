import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[][] adj, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        System.out.println(adj[N-1][M-1]);
    }

    private static void solve() {
        bfs(0, 0);
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer> que = new LinkedList<>();
        que.add(startX);
        que.add(startY);
        visited[startX][startY] = true;

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (adj[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                que.add(nx);
                que.add(ny);
                visited[nx][ny] = true;

                adj[nx][ny] = adj[x][y] + 1;
            }
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
