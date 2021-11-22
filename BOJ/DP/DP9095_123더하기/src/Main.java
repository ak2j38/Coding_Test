import java.io.*;

public class Main {
    static int N;
    static int[] DP, T;
    static final int MAX_SIZE = 11;

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
        for (int num : T) {
            System.out.println(DP[num]);
        }
    }

    static void solve() {
        // 초기값 셋팅
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        // 점화식 생성 및 배열 채우기
        for (int i=4; i<=MAX_SIZE; i++) {
            DP[i] = DP[i-3] + DP[i-2] + DP[i-1];
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        DP = new int[MAX_SIZE+1];
        T = new int[N];
        for (int i=0; i<N; i++) {
            T[i] = Integer.parseInt(br.readLine());
        }
    }
}
