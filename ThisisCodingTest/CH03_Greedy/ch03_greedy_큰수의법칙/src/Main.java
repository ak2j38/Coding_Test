import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N, M, K, ANSWER;
    static Integer[] nums;

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
        System.out.println(ANSWER);
    }

    static void solve() {
        Arrays.sort(nums, Collections.reverseOrder());

        if (nums[0] == nums[1]) {
            ANSWER = nums[0] * M;
        } else {
            ANSWER = (nums[0] * (K * (M / K))) + (nums[1] * ((M % K)));
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        K = Integer.parseInt(split[2]);
        ANSWER = 0;
        nums = new Integer[N];
        split = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
    }
}
