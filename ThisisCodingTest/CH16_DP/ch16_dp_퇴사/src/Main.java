import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static int N;
    static int[] DP;
    static Counsel[] counsels;

    static class Counsel {
        int needDay;
        int pay;

        public Counsel(int needDay, int pay) {
            this.needDay = needDay;
            this.pay = pay;
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

    // 아이디어
    // 뒤쪽부터 매 상담에 대해 "현재 상담 일자의 이윤 + 현재 상담을 마친 일자부터의 최대 이윤"
    private static void solve() {
        int maxValue = 0;

        // 점화식 생성
        for (int i = N - 1; i >= 0; i--) {
            int time = counsels[i].needDay + i;

            if (time <= N) {
                DP[i] = Math.max(counsels[i].pay + DP[time], maxValue);
                maxValue = DP[i];
            } else {
                DP[i] = maxValue;
            }
        }

        // 결과 출력
        System.out.println(maxValue);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        DP = new int[N + 1];
        counsels = new Counsel[N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            counsels[i] = new Counsel(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
    }
}
