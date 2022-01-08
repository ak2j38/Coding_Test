import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int N;
    static ArrayList<Integer>[] triangle;
    static int[][] DP;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        System.out.println(Arrays.stream(DP[N - 1]).max().getAsInt());
    }

    private static void solve() {
        // 초기값 셋팅
        DP[0][0] = triangle[0].get(0);

        // 점화식 생성
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].size(); j++) {
                if (j == 0) DP[i][j] = DP[i - 1][j] + triangle[i].get(j);
                else if (j == triangle[i].size() - 1) DP[i][j] = DP[i - 1][j - 1] + triangle[i].get(j);
                else DP[i][j] = triangle[i].get(j) + Math.max(DP[i - 1][j], DP[i - 1][j - 1]);
            }
        }
    }

    private static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        triangle = new ArrayList[N];
        DP = new int[N][N];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                triangle[i].add(Integer.parseInt(split[j]));
            }
        }
    }
}
