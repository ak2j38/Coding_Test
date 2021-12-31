import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Character> alphas;
    static ArrayList<Integer> nums;
    static StringBuilder sb;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        // 문자 정렬
        Collections.sort(alphas);
        for (Character alpha : alphas) {
            sb.append(alpha);
        }
        // 숫자 합
        sb.append(nums.stream().mapToInt(value -> value).sum());

        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split("");
        alphas = new ArrayList<>();
        nums = new ArrayList<>();
        sb = new StringBuilder();
        for (String s : split) {
            Character ch = s.toCharArray()[0];
            if (isNum(ch)) {
                nums.add(Integer.parseInt(s));
            } else {
                alphas.add(ch);
            }
        }
    }

    private static boolean isNum(Character ch) {
        return Character.isDigit(ch);
    }
}
