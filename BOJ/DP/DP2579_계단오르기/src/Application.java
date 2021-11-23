import java.io.*;

public class Application {
    static int N;
    static int[] stairs;
    static int[][] DP;

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
        System.out.println(Math.max(DP[N-1][0], DP[N-1][1]));
    }

    static void solve() {
        // 엣지케이스
        if (N == 1) {
            DP[N-1][0] = stairs[0];
            return;
        }

        // DP배열 정의 및 가짜문제 정의
        // DP[i][0] = i-1 안 밟은고 i번째 계단 최댓값  / DP[i][1] = i-1 밟은거 i번째 계단 최댓값
        // 초기값 셋팅
        DP[0][0] = stairs[0];
        DP[0][1] = stairs[0];
        DP[1][0] = stairs[1];
        DP[1][1] = stairs[0] + stairs[1];

        // 점화식 및 DP 배열 채우기
        for (int i=2; i<N; i++) {
            DP[i][0] = Math.max(DP[i-2][0]+stairs[i], DP[i-2][1]+stairs[i]);
            DP[i][1] = DP[i-1][0] + stairs[i];
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        stairs = new int[N];
        DP = new int[N][2];
        for (int i=0; i<N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
    }
}
