import java.io.*;

public class Main {
    static int N;
    static int[] DP;
    static final int MAX_SIZE = 1000;

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
        // 정답 출력
        System.out.println(DP[N]);
    }

    static void solve() {
        // 초기값 셋팅
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 3;
        DP[4] = 5;

        // 점화식 및 배열 채우기
        for (int i=5; i<=MAX_SIZE; i++) {
            DP[i] = (DP[i-2] + DP[i-1]) % 10007;
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        DP = new int[MAX_SIZE+1];
    }
}
