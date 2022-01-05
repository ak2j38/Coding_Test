import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        int answer = 0;
        Arrays.sort(nums, 1, N);

        for (int i = 0; i < N; i++) {
            if (binarySearch(0, N - 1, i)) {
                answer = i;
                break;
            }
        }

        if (answer == 0) System.out.println(-1);
        else System.out.println(answer);
    }

    private static boolean binarySearch(int L, int R, int target) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (nums[mid] <= nums[target]) {
                if (nums[mid] == target) return true;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
    }
}
