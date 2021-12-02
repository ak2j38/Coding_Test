import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int N, M, MAX;
    static int[][] cards;

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
        System.out.println(MAX);
    }

    static void solve() {
        for (int i=0; i<N; i++) {
            MAX = Math.max(MAX, Arrays.stream(cards[i]).min().getAsInt());
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        MAX = Integer.MIN_VALUE;
        cards = new int[N][M];

        for (int i=0; i<N; i++) {
            split = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                cards[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
