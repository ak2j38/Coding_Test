import java.io.*;

public class Main {
    static int N;
    static int[][] DP;
    static final int MOD = 9901;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {
        // 정답 출력  (N=4 -> 정답 41)
        System.out.println((DP[N][0] + DP[N][1] + DP[N][2]) % MOD);
    }

    static void solve() {
        // 초기값 셋팅
        // DP 배열 의미 -> 해당 열까지 오는 데 최대 경우의 수
        DP[1][0] = 1;
        DP[1][1] = 1;
        DP[1][2] = 1;

        // 점화식 생성 및 DP배열 채우기
        for (int i=2; i<=N; i++) {
            DP[i][0] = (DP[i-1][0] + DP[i-1][1] + DP[i-1][2]) % MOD;
            DP[i][1] = (DP[i-1][0] + DP[i-1][2]) % MOD;
            DP[i][2] = (DP[i-1][0] + DP[i-1][1]) % MOD;
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        DP = new int[N+1][3];
    }
}
