import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N, T;
    static int[] dist;
    static int[][] adj, dir = {{1,0},{0,1},{-1,0},{0,-1}};

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {
//        System.out.println(String.format("Problem %d,: %d", T, dist[N-1]));
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void bfs() {
        // 시작점 0,0  도착점 N-1,N-1
        print();
    }

    static void dijkstra() {
        for (int i=0; i<N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }


    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));
        T = 0;

        while (true) {
            N = Integer.parseInt(br.readLine());
            T++;
            if (N == 0) break;
            dist = new int[N];
            edges = new ArrayList[N];
            for (int i=0; i<N; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i=0; i<N; i++) {
                String[] split = br.readLine().split(" ");
                int length = split.length;
                for (int j=0; j<length; j++) {
                    adj[i][j] = Integer.parseInt(split[j]);
                }
            }
            bfs();
        }
    }
}


