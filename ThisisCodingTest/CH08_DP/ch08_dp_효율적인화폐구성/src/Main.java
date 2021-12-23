import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] DP, MONEYS;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        Arrays.fill(DP, Integer.MAX_VALUE);

        DP[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = MONEYS[i]; j <= M; j++) {
                if (DP[j - MONEYS[i]] != Integer.MAX_VALUE){
                    DP[j] = Math.min(DP[j], DP[j - MONEYS[i]] + 1);
                }
            }
        }

        System.out.println(DP[M]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        DP = new int[M + 1];
        MONEYS = new int[N];
        for (int i = 0; i < N; i++) {
             MONEYS[i] = Integer.parseInt(br.readLine());
        }
    }
}
