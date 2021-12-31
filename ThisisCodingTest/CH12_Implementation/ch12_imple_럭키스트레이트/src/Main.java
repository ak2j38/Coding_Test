import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static String NUM;
    static int[] NUMS;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        if (calc(1, NUM.length() / 2) == calc((NUM.length() / 2) + 1, NUM.length())) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }

    private static int calc(int startIdx, int endIdx) {
        int sum = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            sum += NUMS[i];
        }
        return sum;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        NUM = br.readLine();
        NUMS = new int[NUM.length() + 1];
        for (int i = 1; i <= NUM.length(); i++) {
            NUMS[i] = Integer.parseInt(NUM.substring(i - 1, i));
        }
    }
}
