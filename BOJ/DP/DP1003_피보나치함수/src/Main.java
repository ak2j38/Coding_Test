import java.io.*;

public class Main {
    static int T;
    static int[] N;
    static FibonacciCount[] DP;
    static final int MAX_SIZE = 40;

    static class FibonacciCount {
        int zeroCnt, oneCnt;

        public FibonacciCount(int zeroCnt, int oneCnt) {
            this.zeroCnt = zeroCnt;
            this.oneCnt = oneCnt;
        }
    }

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
        for (int num : N) {
            System.out.println(DP[num].zeroCnt + " " + DP[num].oneCnt);
        }
    }

    static void solve() {
        // 초기값 셋팅
        DP[0] = new FibonacciCount(1, 0);
        DP[1] = new FibonacciCount(0, 1);
        DP[2] = new FibonacciCount(1, 1);

        // 점화식 생성 및 배열 채우기
        for(int i=3; i<=MAX_SIZE; i++) {
            DP[i] = new FibonacciCount((DP[i-2].zeroCnt + DP[i-1].zeroCnt), (DP[i-2].oneCnt + DP[i-1].oneCnt));
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        T = Integer.parseInt(br.readLine());
        N = new int[T];
        DP = new FibonacciCount[MAX_SIZE+1];
        for (int i=0; i<T; i++) {
            N[i] = Integer.parseInt(br.readLine());
        }
    }
}
