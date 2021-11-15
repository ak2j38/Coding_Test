import java.io.*;
import java.util.*;

public class Main {
    static int N, T, answer;
    static int[][] dist, adj, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visited;

    static class Node {
        int from, to, weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        try {
            input();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {
        System.out.println(String.format("Problem %d: %d", T, dist[N-1][N-1]));
    }

    static void dijkstra() {
        // 시작점 0,0  도착점 N-1,N-1
        for (int i=0; i<N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> que = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        que.add(new Node(0, 0, adj[0][0])); // 시작점 넣어주기
        visited[0][0] = true;
        dist[0][0] = adj[0][0];

        while (!que.isEmpty()) {
            Node node = que.poll();

            // 원하는 곳 도착
            if (node.from == N-1 && node.to == N-1) break;
            // 의미없으면 폐기
            if (node.weight != dist[node.from][node.to]) continue;

            // 4가지 방향 중 최솟값을 찾아서 그 쪽으로 이동해야한다
            for (int k=0; k<4; k++) {
                int nx = node.from + dir[k][0];
                int ny = node.to + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                // 거리 계산
                if (dist[node.from][node.to] + adj[nx][ny] >= dist[nx][ny]) continue;

                dist[nx][ny] = dist[node.from][node.to] + adj[nx][ny];
                que.add(new Node(nx, ny, dist[nx][ny]));
                visited[nx][ny] = true;
            }

        }
        print();
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));
        T = 0;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            T++;
            dist = new int[N][N];
            adj = new int[N][N];
            visited = new boolean[N][N];
            for (int i=0; i<N; i++) {
                String[] split = br.readLine().split(" ");
                for (int j=0; j<N; j++) {
                    adj[i][j] = Integer.parseInt(split[j]);
                }
            }
            answer = adj[0][0];
            dijkstra();
        }
    }
}


