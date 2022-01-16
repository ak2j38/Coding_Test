import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static int N, M;
    static int[][] adj;
    static int[] parents, candidates;
    static boolean flag;

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
        if (flag) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    private static void solve() {
        // adj 배열의 1 값들을 찾아 unionParent 수행
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adj[i][j] == 1) {
                    unionParent(i, j);
                }
            }
        }

        // candidates 배열을 순회하면서 값이 전부 같은지 판단
        for (int candidate : candidates) {
            if (parents[candidates[0]] != parents[candidate]) {
                flag = true;
            }
        }
    }

    private static int findParent(int x) {
        if (parents[x] != x) {
            parents[x] = findParent(parents[x]);
        }
        return parents[x];
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        adj = new int[N + 1][N + 1];
        parents = new int[N + 1];
        candidates = new int[M];
        flag = false;

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            split = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                adj[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            candidates[i] = Integer.parseInt(split[i]);
        }
    }
}
