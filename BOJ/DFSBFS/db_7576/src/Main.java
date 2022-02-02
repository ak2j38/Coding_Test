import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] map, dist, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public static void main(String[] args) {
        try {
            input();
            System.out.println(solve());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve() {
        // 1은 익은토마토, 0은 안익은토마토, -1은 비어있는 칸
        bfs();


        if (!isAllTomatoOne()) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, dist[i][j]);
            }
        }
        return max;
    }

    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        // 큐에 시작점 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    que.add(i);
                    que.add(j);
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
                if (map[nx][ny] == 1 || map[nx][ny] == -1) continue;

                // 아직 익지 않은 토마토
                map[nx][ny] = 1;
                dist[nx][ny] = dist[x][y] + 1;
                que.add(nx);
                que.add(ny);
            }
        }
    }

    private static boolean isAllTomatoOne() {
        // 모든 토마토가 익을 수 없으면 false
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
