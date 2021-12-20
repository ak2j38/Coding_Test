import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static ArrayList<Integer> NUMS;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        Collections.sort(NUMS, Collections.reverseOrder());
        for (int num : NUMS) {
            System.out.print(num + " ");
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        N = Integer.parseInt(br.readLine());
        NUMS = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            NUMS.add(Integer.parseInt(br.readLine()));
        }
    }
}
