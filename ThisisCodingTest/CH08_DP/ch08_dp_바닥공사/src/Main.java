import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static int N;
    static int[] DP;
    static final int DIV_NUM = 796796;

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
        DP[1] = 1;
        DP[2] = 3;
        DP[3] = 5;

        // 점화식 생성
        for (int i = 4; i <= N; i++) {
            DP[i] = (DP[i - 1] + (DP[i - 2] * 2)) % DIV_NUM;
        }

        // 정답 출력
        System.out.println(DP[N]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        N = Integer.parseInt(br.readLine());
        DP = new int[N + 1];
    }
}
