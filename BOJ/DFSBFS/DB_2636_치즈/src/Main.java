import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, cheesesCnt;
    static int[][] adj, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
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

        int time = 0;
        int lastCheeseCnt = 0;
        while (cheesesCnt != 0) {
            time++;
            lastCheeseCnt = cheesesCnt;
            bfs(0, 0, time);
        }

        System.out.println(time + " " + lastCheeseCnt);
    }

    private static void bfs(int startX, int startY, int time) {
        Queue<Integer> que = new LinkedList<>();
        que.add(startX);
        que.add(startY);
        visited = new boolean[N][M];
        visited[startX][startY] = true;

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (adj[nx][ny] == 0) {
                    que.add(nx);
                    que.add(ny);
                }
                if (adj[nx][ny] == 1) {
                    cheesesCnt -= 1;
                    adj[nx][ny] = 0;
                }
                visited[nx][ny] = true;
            }
        }
    }

    private static void input() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        adj = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                adj[i][j] = Integer.parseInt(split[j]);
                if (adj[i][j] == 1) {
                    cheesesCnt += 1;
                }
            }
        }
    }
}
