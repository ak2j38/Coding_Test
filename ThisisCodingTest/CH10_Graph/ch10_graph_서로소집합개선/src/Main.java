import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();
        for (int i = 1; i <= N; i++) {
            System.out.print(parent[i] + " ");
        }
    }

    static void initParent() {
        // 부모테이블 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    static int findParent(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }

    static void unionParent(int node1, int node2) {
        node1 = findParent(node1);
        node2 = findParent(node2);

        if (node1 < node2) {
            parent[node2] = node1;
        } else {
            parent[node1] = node2;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        parent = new int[N + 1];
        initParent();

        for (int i = 1; i <= M; i++) {
            split = br.readLine().split(" ");
            unionParent(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
    }
}
