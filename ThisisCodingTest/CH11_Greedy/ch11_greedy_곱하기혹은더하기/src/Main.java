import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static int N, ANSWER;
    static String[] NUMS, OP;

    public static void main(String[] args) {
        try {
            input();
            solve(1, Integer.parseInt(NUMS[1]));
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int k, int result) {
        // N - 1 만큼 (+ or *)를 뽑는다(중복허용)
        if (k == N) {
            // 다 찾았다(계산값 갱신시도)
            ANSWER = Math.max(ANSWER, result);
        } else {
            // 중복순열
            for (int cand = 1; cand <= N; cand++) {

                if (cand % 2 == 0) {
                    OP[k] = "+";
                } else {
                    OP[k] = "*";
                }

                solve(k + 1, calc(result, OP[k], Integer.parseInt(NUMS[k + 1])));
                OP[k] = "";
            }
        }
    }

    private static int calc(int operand1, String operator, int operand2) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        }
        return operand1 * operand2;
    }

    private static void print() {
        System.out.println(ANSWER);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String input = br.readLine();
        NUMS = new String[input.length() + 1];
        OP = new String[input.length()];
        ANSWER = Integer.MIN_VALUE;
        N = input.length();

        for (int i = 1; i <= N; i++) {
            NUMS[i] = input.substring(i-1, i);
        }
    }
}
