import java.io.*;

public class Main {
    static int N;
    static int[] F;

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
        System.out.println(F[N]);
    }

    static void solve() {
        // 초기값 셋팅
        F[0] = 0;
        if (N > 0) {
            F[1] = 1;
        }

        // 점화식 생성 및 F 배열 채우기
        for (int i=2; i<=N; i++) {
            F[i] = F[i-2] + F[i-1];
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        F = new int[N+1];
    }
}
