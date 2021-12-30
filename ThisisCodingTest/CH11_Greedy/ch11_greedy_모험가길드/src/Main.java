import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] FEARS;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        // 공포도에 따라 정렬
        Arrays.sort(FEARS);

        int groupCnt = 0;
        int nowGroupCnt = 0;
        // 최대의 그룹 수를 출력해야함
        for (int fear : FEARS) {
            nowGroupCnt++;
            if (nowGroupCnt >= fear) {
                groupCnt++;
                nowGroupCnt = 0;
            }
        }
        System.out.println(groupCnt);

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        FEARS = new int[N];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            FEARS[i] = Integer.parseInt(split[i]);
        }
    }
}
