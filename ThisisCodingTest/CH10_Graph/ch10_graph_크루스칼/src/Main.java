import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N, M;
    static ArrayList<Edge> edges;
    static int[] parent;

    public static class Edge implements Comparable<Edge>{
        int dist;
        int node1;
        int node2;

        public Edge(int node1, int node2, int dist) {
            this.dist = dist;
            this.node1 = node1;
            this.node2 = node2;
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
        int result = 0;
        // 정렬
        Collections.sort(edges);

        // 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인
        for (Edge edge : edges) {
            // 발생하지 않으면 최소신장트리에 포함
            if (findParent(edge.node1) != findParent(edge.node2)) {
                unionParent(edge.node1, edge.node2);
                result += edge.dist;
            }
        }

        System.out.println(result);
    }

    static int findParent(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node]); // 이 부분 자주 실수하니 확인!!
    }

    static void unionParent(int node1, int node2) {
        node1 = findParent(node1);
        node2 = findParent(node2);
        if (node1 < node2) parent[node2] = node1;
        else parent[node1] = node2;
    }

    static void initParent() {
        for (int i=1; i<=N; i++) {
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
        initParent();

        for (int i = 1; i <= M; i++) {
            split = br.readLine().split(" ");
            edges.add(new Edge(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }
    }
}
