import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            solve(input());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(String s) {
        int reverseCntZero = 0, reverseCntOne = 0;
        boolean flagZero = false, flagOne = false;

        // 한 번에 0 1을 모두 판단하는 방법?
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                if (!flagZero) {
                    flagZero = true;
                    flagOne = false;
                    reverseCntZero++;
                }
            } else {
                if (!flagOne) {
                    flagOne = true;
                    flagZero = false;
                    reverseCntOne++;
                }
            }
        }

        // 정답 출력
        System.out.println(Math.min(reverseCntZero, reverseCntOne));
    }

    private static String input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        return br.readLine();
    }
}
