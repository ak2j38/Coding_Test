import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int N;
    static int[] times, indeg, SUM;
    static ArrayList<Integer>[] adj;

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
        for (int i = 1; i <= N; i++) {
            System.out.println(SUM[i]);
        }
    }

    private static void solve() {
        Deque<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
            }
            SUM[i] += times[i];
        }

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : adj[x]) {
                indeg[y]--;
                SUM[y] = Math.max(SUM[y], SUM[x] + times[y]);
                if (indeg[y] == 0) que.add(y);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        SUM = new int[N + 1];
        indeg = new int[N + 1];
        times = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split(" ");
            times[i] = Integer.parseInt(split[0]);
            for (int j = 1; j < split.length; j++) {
                if (Integer.parseInt(split[j]) == -1) continue;
                adj[Integer.parseInt(split[j])].add(i);
                indeg[i]++;
            }
        }
    }
}
