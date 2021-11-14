import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N, M, X;
    static int[] dist, distReverse;
    static ArrayList<Edge>[] edges, edgesReverse;

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        try {
            input();
            solve();
            solveReverse();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {
        int max = Integer.MIN_VALUE;
        for (int i=1; i<=N; i++) {
            max = Math.max(max, dist[i]+distReverse[i]);
        }
        System.out.println(max);
    }

    static void solveReverse() {
        for (int i=1; i<=N; i++) {
            distReverse[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(X, 0));
        distReverse[X] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            // 뽑은 정보가 의미없는 정보면 컨티뉴
            if(info.dist != distReverse[info.idx]) continue;

            for (Edge e : edgesReverse[info.idx]) {
                if(distReverse[info.idx] + e.weight >= distReverse[e.to]) continue;

                distReverse[e.to] = distReverse[info.idx] + e.weight;
                pq.add(new Info(e.to, distReverse[e.to]));
            }
        }
    }

    static void solve() {
        for (int i=1; i<=N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(X, 0));
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            // 뽑은 정보가 의미없는 정보면 컨티뉴
            if(info.dist != dist[info.idx]) continue;

            for (Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        X = Integer.parseInt(split[2]);
        dist = new int[N+1];
        distReverse = new int[N+1];
        edges = new ArrayList[N+1];
        edgesReverse = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            edgesReverse[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            split = br.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int cost = Integer.parseInt(split[2]);
            edges[from].add(new Edge(to, cost));
            edgesReverse[to].add(new Edge(from, cost));
        }
    }
}
