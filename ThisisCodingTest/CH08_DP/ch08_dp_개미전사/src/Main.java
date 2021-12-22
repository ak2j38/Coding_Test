import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static int N;
    static int[] DP, FOODS;

    public static void main(String[] args) {
        try {
            input();
            solve();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        // 초기값 셋팅
        DP[1] = FOODS[1];
        DP[2] = Math.max(DP[1], FOODS[2]);
        DP[3] = Math.max(DP[2], DP[1] + FOODS[3]);

        // 점화식 생성
        for (int i = 4; i <= N; i++) {
            DP[i] = Math.max(DP[i - 1], DP[i - 2] + FOODS[i]);
        }

        // 정답 출력
        System.out.println(DP[N]);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        N = Integer.parseInt(br.readLine());
        DP = new int[N + 1];
        FOODS = new int[N + 1];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            FOODS[i + 1] = Integer.parseInt(split[i]);
        }
    }
}
