import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N, M, C;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static StringBuilder sb;

    static class Info {
        int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
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

    private static void print() {
        // 최단거리 갱신된 도시와 최대거리 sb에 추가
        long cityCnt = Arrays.stream(dist)
                                        .filter(o -> (o != 0 && o != Integer.MAX_VALUE))
                                        .count();
        int longestPath = Arrays.stream(dist)
                                        .filter(value -> value != Integer.MAX_VALUE)
                                        .max()
                                        .getAsInt();

        sb.append(cityCnt + " " + longestPath);

        System.out.println(sb);
    }

    private static void solve() {
        // C 도시에서 출발
        dijkstra(C);
    }

    private static void dijkstra(int start) {
        // 거리 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // 시작점 초기화
        dist[start] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.dist));
        pq.add(new Info(start, 0));

        // 최단거리 계산
        while (!pq.isEmpty()) {
            Info info = pq.poll();

            // 최신정보 아니면 컨티뉴
            if (dist[info.idx] != info.dist) continue;

            // 최단거리 갱신 및 큐에 추가
            for (Edge e : edges[info.idx]) {
                // e.to 까지 갈 수 있는 최단거리를 찾으면 갱신
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        C = Integer.parseInt(split[2]);
        edges = new ArrayList[N + 1];
        dist = new int[N + 1];
        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int z = Integer.parseInt(split[2]);
            edges[x].add(new Edge(y, z));
        }
    }
}
