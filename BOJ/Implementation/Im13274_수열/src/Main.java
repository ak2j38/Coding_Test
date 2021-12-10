import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, K, L, R, X;
    static long[] NUMS;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {

        for (int i = 1; i <= N; i++) {
            sb.append(NUMS[i] + " ");
        }
        System.out.println(sb);
    }

    static void solve(int L, int R, int X) {

        for (int i = L; i <= R; i++) {
            NUMS[i] += X;
        }

        Arrays.sort(NUMS);
    }

    static void input() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        NUMS = new long[N + 1];

        split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            NUMS[i + 1] = Long.parseLong(split[i]);
        }

        Arrays.sort(NUMS);

        for (int i = 0; i < K; i++) {
            split = br.readLine().split(" ");
            L = Integer.parseInt(split[0]);
            R = Integer.parseInt(split[1]);
            X = Integer.parseInt(split[2]);
            solve(L, R, X);
        }
    }
}
