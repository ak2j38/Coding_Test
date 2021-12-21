import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int N, M;
    static long H;
    static int[] riceCakes;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        // 매개변수 탐색을 하기 위해 riceCakes 정렬
        Arrays.sort(riceCakes);

        long L = 0, R = Arrays.stream(riceCakes).max().getAsInt();

        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                H = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(H);
    }

    private static boolean determination(long mid) {
        return Arrays.stream(riceCakes).filter(value -> value >= mid)
                                        .mapToLong(value -> value - mid)
                                        .sum() >= M;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        H = 0;
        riceCakes = new int[N];

        split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            riceCakes[i] = Integer.parseInt(split[i]);
        }
    }
}
