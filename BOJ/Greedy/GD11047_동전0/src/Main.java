import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N, K, ANSWER;
    static Integer[] coins;

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
        System.out.println(ANSWER);
    }

    static void solve() {
        Arrays.sort(coins, Collections.reverseOrder());

        for (int num : coins) {
            if (K >=  num) {
                ANSWER += K / num;
                K %= num;
            }
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        coins = new Integer[N];
        ANSWER = 0;
        for (int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
    }
}
