import java.io.*;

public class Main {
    static int T, N, H, W;
    static StringBuilder sb;

    public static void main(String[] args) {
        try {
            input();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {
        System.out.println(sb);
    }

    static void solve() {
        // 방 배정하기
        int h = 0;
        int w = 0;

        // 최상층일 때
        if (N % H == 0) {
            h = H;
            w = N / H;
        } else {
            h = N % H;
            w = (N / H) + 1;
        }

        sb.append(h).append(String.format("%02d", w)).append("\n");
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            String[] split = br.readLine().split(" ");
            H = Integer.parseInt(split[0]);
            W = Integer.parseInt(split[1]);
            N = Integer.parseInt(split[2]);

            solve();
        }
    }
}
