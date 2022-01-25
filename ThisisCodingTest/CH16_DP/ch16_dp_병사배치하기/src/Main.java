import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] DP;
    static Soldier[] soldiers;

    static class Soldier{
        int index;
        int power;

        public Soldier(int index, int power) {
            this.index = index;
            this.power = power;
        }

        @Override
        public String toString() {
            return "Soldier{" +
                    "index=" + index +
                    ", power=" + power +
                    '}';
        }
    }

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        // 초기값 설정
        DP[0] = 1;

        // 점화식 생성 - LIS 알고리즘
        for (int i = 1; i < N; i++) {
            DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (soldiers[j].power > soldiers[i].power) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
        }

        // 정답 출력
        System.out.println(N - getSoliderCount());
    }

    static int getSoliderCount() {
        return (int) Arrays.stream(DP)
                .distinct()
                .count();
    }

    private static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        soldiers = new Soldier[N];
        DP = new int[N];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            soldiers[i] = new Soldier(i, Integer.parseInt(split[i])) ;
        }
    }
}
