import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, C;
    static int[] houses;

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
        Arrays.sort(houses, 1, N + 1);

        int L = 1, R = 1_000_000_000, answer = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                answer = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean determination(int distance) {
        int wifiCnt = 1;
        int last = houses[1];

        // distance 마다 설치해서 C개를 설치할 수 있는지
        for (int i = 2; i <= N; i++) {
            if (houses[i] - last < distance) continue;
            wifiCnt++;
            last = houses[i];
        }

        return wifiCnt >= C;
    }

    private static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        houses = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
    }
}
