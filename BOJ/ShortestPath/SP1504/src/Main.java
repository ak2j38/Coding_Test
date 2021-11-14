import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static int N, M, NODE1, NODE2;
    static int[] dist1, dist2, dist3;
    static ArrayList<Edge>[] edges;

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
            dijkstraToNode1();
            dijkstraToNode2();
            dijkstraToN();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {
        // 경로가 없다면 -1 출력
        if (dist1[NODE1] == Integer.MAX_VALUE || dist2[NODE2] == Integer.MAX_VALUE || dist3[N]  == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            // dist1,2,3 배열들을 가지고 최단거리 구하기 - case2
            int case1 = dist1[NODE1] + dist2[NODE2] + dist3[N];
            int case2 = dist1[NODE2] + dist2[NODE2] + dist2[N];
            System.out.println(Math.min(case1, case2));
        }
    }

    static void dijkstraToNode1() {
        // 거리 초기화
        for (int i=1; i<=N; i++) {
            dist1[i] = Integer.MAX_VALUE;
        }

        // 우선순위 큐 선언
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2)->o1.dist-o2.dist);
        pq.add(new Info(1, 0));
        dist1[1] = 0;

        // 큐 빌때까지
        while (!pq.isEmpty()) {
            Info info = pq.poll();

            // 의미 없으면 폐기
            if (info.dist != dist1[info.idx]) continue;

            for (Edge e : edges[info.idx]) {
                if (dist1[info.idx] + e.weight >= dist1[e.to]) continue;

                dist1[e.to] = dist1[info.idx] + e.weight;
                pq.add(new Info(e.to, dist1[e.to]));
            }
        }
    }

    static void dijkstraToNode2() {
        // 거리 초기화
        for (int i=1; i<=N; i++) {
            dist2[i] = Integer.MAX_VALUE;
        }

        // 우선순위 큐 선언
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2)->o1.dist-o2.dist);
        pq.add(new Info(NODE1, 0));
        dist2[NODE1] = 0;

        // 큐 빌때까지
        while (!pq.isEmpty()) {
            Info info = pq.poll();

            // 의미 없으면 폐기
            if (info.dist != dist2[info.idx]) continue;

            for (Edge e : edges[info.idx]) {
                if (dist2[info.idx] + e.weight >= dist2[e.to]) continue;

                dist2[e.to] = dist2[info.idx] + e.weight;
                pq.add(new Info(e.to, dist2[e.to]));
            }
        }
    }

    static void dijkstraToN() {
        // 거리 초기화
        for (int i=1; i<=N; i++) {
            dist3[i] = Integer.MAX_VALUE;
        }

        // 우선순위 큐 선언
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2)->o1.dist-o2.dist);
        pq.add(new Info(NODE2, 0));
        dist3[NODE2] = 0;

        // 큐 빌때까지
        while (!pq.isEmpty()) {
            Info info = pq.poll();

            // 의미 없으면 폐기
            if (info.dist != dist3[info.idx]) continue;

            for (Edge e : edges[info.idx]) {
                if (dist3[info.idx] + e.weight >= dist3[e.to]) continue;

                dist3[e.to] = dist3[info.idx] + e.weight;
                pq.add(new Info(e.to, dist3[e.to]));
            }
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        dist1 = new int[N+1];
        dist2 = new int[N+1];
        dist3 = new int[N+1];
        edges = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            split = br.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int weight = Integer.parseInt(split[2]);
            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }
        split = br.readLine().split(" ");
        NODE1 = Integer.parseInt(split[0]);
        NODE2 = Integer.parseInt(split[1]);
    }
}
