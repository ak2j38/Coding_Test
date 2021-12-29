import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int N, M;
    static List<Edge> edges;
    static int[] parent;

    static class Edge implements Comparable<Edge>{
        int from, to, dist;

        public Edge(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge other) {
            return this.dist - other.dist;
        }
    }

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        int result = 0, maxDist = 0;

        initParent();
        // 간선 크기대로 정렬
        Collections.sort(edges);

        for (Edge edge : edges) {
            if (findParent(edge.from) != findParent(edge.to)) {
                unionParent(edge.from, edge.to);
                result += edge.dist;
                maxDist = Math.max(maxDist, edge.dist);
            }
        }

        result -= maxDist;

        System.out.println(result);
    }

    private static void unionParent(int from, int to) {
        from = findParent(from);
        to = findParent(to);

        if (from < to) {
            parent[to] = from;
        } else {
            parent[from] = to;
        }
    }

    private static int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    static void initParent() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        edges = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            split = br.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int dist = Integer.parseInt(split[2]);

            edges.add(new Edge(from, to, dist));
        }
    }
}
