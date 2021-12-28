import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();

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
        System.out.println(sb);
    }

    private static void solve() {
        Deque<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            // sb에 추가
            sb.append(x + " ");

            for (int y : adj[x]) {
                // indeg값 --
                indeg[y]--;
                // 큐에 넣기
                if (indeg[y] == 0) que.add(y);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        indeg = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            adj[Integer.parseInt(split[0])].add(Integer.parseInt(split[1]));
            indeg[Integer.parseInt(split[1])]++;
        }
    }
}
