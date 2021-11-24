import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] DP, P;

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
        for (int num : DP) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(DP[N]);
    }

    static void solve() {
        // 초기값 셋팅
        DP[1] = P[1];
        if (N>1) {
            DP[2] = Math.max(P[1]*2, P[2]);
        }
        // 점화식 생성 및 DP 배열 채우기
        for (int i=3; i<=N; i++) {
            for (int j=1; j<=i; j++) {
                DP[i] = Math.max(DP[i-j]+P[j], DP[i]);
            }
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        DP = new int[N+1];
        P = new int[N+1];
        String[] split = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            P[i+1] = Integer.parseInt(split[i]);
        }
    }
}
