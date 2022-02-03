import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] trees;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        // 매개변수 탐색
        Arrays.sort(trees);

        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long L = 1, R = 1_000_000_000, res = 0;

        while(L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                res = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return res;
    }

    private static boolean determination(long mid) {
        return Arrays.stream(trees)
                .filter(value -> value > mid)
                .mapToLong(value -> value - mid)
                .sum() >= M;
    }

    private static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        trees = new int[N + 1];

        split = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            trees[i] = Integer.parseInt(split[i - 1]);
        }
    }
}
