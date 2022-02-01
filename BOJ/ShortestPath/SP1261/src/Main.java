import java.io.*;
import java.util.PriorityQueue;

public class Main {

    static int M, N;
    static int[][] map, dist, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static class Point implements Comparable<Point> {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
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

    private static void solve() {
        bfs();
    }

    private static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        // x, y, cost 순으로 넣기
        pq.add(new Point(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Point point = pq.poll();

            for (int k = 0; k < 4; k++) {
                int nx = point.x + dir[k][0];
                int ny = point.y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (dist[nx][ny] <= dist[point.x][point.y] + map[nx][ny]) continue;

                dist[nx][ny] = dist[point.x][point.y] + map[nx][ny];
                pq.add(new Point(nx, ny, dist[nx][ny]));
            }
        }
    }

    private static void print() {
        System.out.println(dist[N - 1][M - 1]);
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
            split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}
