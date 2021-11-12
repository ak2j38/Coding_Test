import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N, M, START, GOAL;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static class Info {
        int idx, dist;

        public Info(int idx, int dist){
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
            solve(START);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve (int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화 해주기.
        // 문제의 정답으로 가능한 거리의 최댓값보다 큰 값임을 보장해야 한다.
        for (int i=1; i<=N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        // 시작점에 대한 정보(Information)을 기록에 추가하고, 거리 배열(dist)에 갱신해준다.
        pq.add(new Info(start, 0));
        dist[start] = 0;

        // 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while (!pq.isEmpty()) {
            Info info = pq.poll();

            // 꺼낸 정보가 최신 정보랑 다르면, 의미없이 낡은 정보이므로 폐기한다.
            if (dist[info.idx] != info.dist) continue;

            // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신해준다.
            for (Edge e : edges[info.idx]) {
                // e.to 까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신하고 PQ에 기록해준다.
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
        System.out.println(dist[GOAL]);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edges = new ArrayList[N+1];
        dist = new int[N+1];
        String[] split;
        for (int i=1; i<=N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            split = br.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int cost = Integer.parseInt(split[2]);
            edges[from].add(new Edge(to, cost));
        }
        split = br.readLine().split(" ");
        START = Integer.parseInt(split[0]);
        GOAL = Integer.parseInt(split[1]);
    }
}
