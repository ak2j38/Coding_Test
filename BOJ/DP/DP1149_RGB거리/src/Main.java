import java.io.*;

public class Main {
    static int N, MIN;
    static Cost[] costs;
    static int[] DP;

    static class Cost {
        int red, green, blue;

        public Cost(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }

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
        System.out.println(Math.min(DP[0], Math.min(DP[1], DP[2])));
    }

    static void solve() {
        // 초기값 셋팅 DP 배열의 0~2번지는 시작점이 각각 r,g,b
        DP[0] = costs[1].red;
        DP[1] = costs[1].green;
        DP[2] = costs[1].blue;

        // 점화식 생성 및 배열 채우기
        for(int i=2; i<=N; i++) {
            int red = DP[0];
            int green = DP[1];
            int blue = DP[2];

            DP[0] = Math.min(green + costs[i].red, blue + costs[i].red);
            DP[1] = Math.min(red + costs[i].green, blue + costs[i].green);
            DP[2] = Math.min(red + costs[i].blue, green + costs[i].blue);
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        MIN = Integer.MAX_VALUE;
        DP = new int[3];
        costs = new Cost[N+1];
        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            int red = Integer.parseInt(split[0]);
            int green = Integer.parseInt(split[1]);
            int blue = Integer.parseInt(split[2]);
            costs[i+1] = new Cost(red, green, blue);
        }
    }
}
