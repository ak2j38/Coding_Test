import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] adj, dist, dir = {{1,0},{0,1},{-1,0},{0,-1}};

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
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
        System.out.println(dist[N-1][N-1]);
    }

    static void solve() {
        dijkstra();
    }

    static void dijkstra() {
        for (int i=0; i<N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        dist[0][0] = 0;

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (int k=0; k<4; k++) {
                int nx = node.x + dir[k][0];
                int ny = node.y + dir[k][1];

                // 범위 판정
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 흰방 검은방 구분
                // 흰방
                if (adj[nx][ny] == 1) {
                    if (dist[nx][ny] > dist[node.x][node.y]) {
                       dist[nx][ny] = dist[node.x][node.y];
                       que.add(new Node(nx, ny));
                    }
                } else { // 검은방
                    if (dist[nx][ny] > dist[node.x][node.y] + 1) {
                        dist[nx][ny] = dist[node.x][node.y] + 1;
                        que.add(new Node(nx, ny));
                    }
                }
            }
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        dist = new int[N][N];
        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split("");
            for (int j=0; j<N; j++) {
                adj[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
