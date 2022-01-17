import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static int G, P;
    static int[] boardings;
    static int[] parents;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        int count = 0;

        for (int boarding : boardings) {
            if (boarding == 0) continue;
            int data = findParent(boarding);
            if (data == 0) {
                break;
            }
            unionParent(data, data - 1);
            count++;
        }

        System.out.println(count);
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

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        boardings = new int[P];
        parents = new int[G + 1];

        for (int i = 1; i <= G; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < P; i++) {
            boardings[i] = Integer.parseInt(br.readLine());
        }
    }
}
