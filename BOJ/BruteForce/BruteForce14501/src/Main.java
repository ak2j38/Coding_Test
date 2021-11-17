import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N, ANSWER;
    static ArrayList<Counsel>[] counsels;
    static boolean[] visited;
    static int[] paySum;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        rec_func(0, 0);
    }

    static void rec_func(int idx, int sum) {
        // 종료
        if(idx == N) {
            // 최대페이 갱신 가능?
            ANSWER = Math.max(ANSWER, sum);
            return ;
        } else { // N일까지 다다르지 못했을 경우
            // 현재일에 needDay를 더해도 N을 넘지않을 때, N일의 일을 하고 페이를 더함
            if (idx + counsels[idx].get(0).needDay <= N) {
                rec_func(idx + counsels[idx].get(0).needDay, sum + counsels[idx].get(0).pay);
            }
        }
        // 다음날로 가고 페이를 더하지 않음
        rec_func(idx+1, sum);
    }

    static void print() {
        System.out.println(ANSWER);
    }

    static class Counsel {
        int needDay;
        int pay;

        public Counsel (int needDay, int pay) {
            this.needDay = needDay;
            this.pay = pay;
        }

        @Override
        public String toString() {
            return String.format("needDay = %d , pay = %d", this.needDay, this.pay);
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        counsels = new ArrayList[N];
        visited = new boolean[N];
        paySum = new int[N];
        ANSWER = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            counsels[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int needDay = Integer.parseInt(split[0]);
            int pay = Integer.parseInt(split[1]);
            counsels[i].add(new Counsel(needDay, pay));
        }
    }
}
