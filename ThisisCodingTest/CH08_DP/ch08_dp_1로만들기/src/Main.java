import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static int N;
    static int[] DP;

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
        DP[1] = 0;
        DP[2] = 1;
        DP[3] = 2;

        // DP배열을 처음부터 최댓값까지 채워간다
        for (int i = 4; i <= N; i++) {
            DP[i] = DP[i - 1] + 1; // 이전 값에서 -1 연산을 한 번 더함

            if (i % 2 == 0) DP[i] = Math.min(DP[i], DP[i / 2] + 1);
            if (i % 3 == 0) DP[i] = Math.min(DP[i], DP[i / 3] + 1);
            if (i % 5 == 0) DP[i] = Math.min(DP[i], DP[i / 5] + 1);
        }

        // 정답 출력
        System.out.println(DP[N]);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        N = Integer.parseInt(br.readLine());
        DP = new int[N+1];
    }
}
