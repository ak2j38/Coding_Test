import java.io.*;

public class Main {
    static int T;
    static int[] N;
    static long[] DP;
    static final int DIV_NUM = 1_000_000_009;
    static final int MAX_SIZE = 1_000_000;

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
        for (int num : N) {
            System.out.println(DP[num]);
        }
    }

    static void solve() {
        // 초기값 셋팅
        DP[1] = 1; // 1
        DP[2] = 2; // 1+1 / 2
        DP[3] = 4; // 1+1+1 / 2+1 / 1+2 / 3

        // 점화식 생성 및 DP배열 채우기
        for (int i=4; i<=MAX_SIZE; i++) {
            DP[i] = (DP[i-3] + DP[i-2] + DP[i-1]) % DIV_NUM;
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        T = Integer.parseInt(br.readLine());
        N = new int[T];
        DP = new long[MAX_SIZE+1];

        for (int i=0; i<T; i++) {
            N[i] = Integer.parseInt(br.readLine());
        }
    }
}
