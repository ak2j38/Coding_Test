import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] coins, DP;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        int target = 1;
        Arrays.sort(coins);

        for (int coin : coins) {
            if (coin <= target) {
                target += coin;
            } else {
                break;
            }
        }

        System.out.println(target);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        coins = new int[N];
//        DP = new int[N];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(split[i]);
        }
    }
}
