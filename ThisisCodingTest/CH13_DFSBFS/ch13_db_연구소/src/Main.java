import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, safePlaces, blankCnt;
    static int[][] adj, blank, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
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

    private static void solve() {
        // 0은 빈칸, 1은 벽, 2는 바이러스
        collectBlanks();

        // dfs 먼저 3개의 벽을 세운다(0을 1로 변환)
        dfs(0, 0);
    }

    private static void collectBlanks() {
        // 공간을 모아둔다
        blankCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (adj[i][j] == 0) {
                    blank[blankCnt][0] = i;
                    blank[blankCnt][1] = j;
                    blankCnt++;
                }
            }
        }
    }

    private static void dfs(int k, int selectedCnt) {
        if (selectedCnt == 3) {
            bfs();
            return;
        }

        if (k >= blankCnt) {
            return;
        }

        adj[blank[k][0]][blank[k][1]] = 1;
        dfs(k + 1, selectedCnt + 1);
        adj[blank[k][0]][blank[k][1]] = 0;
        dfs(k + 1, selectedCnt);
    }

    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        // multisource bfs(바이러스 위치 큐에 넣는다)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
                if (adj[i][j] == 2) {
                    que.add(i);
                    que.add(j);
                    visited[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (adj[nx][ny] != 0) continue;
                if (visited[nx][ny]) continue;

                que.add(nx);
                que.add(ny);
                visited[nx][ny] = true;
            }
        }

        int safeCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (adj[i][j] == 0 && !visited[i][j]) {
                    safeCnt++;
                }
            }
        }

        safePlaces = Math.max(safePlaces, safeCnt);
    }

    private static void print() {
        System.out.println(safePlaces);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        adj = new int[N][M];
        visited = new boolean[N][M];
        safePlaces = 0;
        blank = new int[N * M + 1][2];

        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                adj[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
