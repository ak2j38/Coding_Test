import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int N, x;
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
        Arrays.sort(nums);

        if (Arrays.stream(nums).anyMatch(value -> value == x)) {
            int lower = lower_bound(1, N + 1, x);
            int upper = upper_bound(1, N + 1, x);

            System.out.println(upper - lower);
        } else {
            System.out.println(-1);

        }
    }

    private static int upper_bound(int L, int R, int target) {
        int result = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (nums[mid] <= target) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }

    private static int lower_bound(int L, int R, int target) {
        int result = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (mid == R) {
                return result;
            }
            if (nums[mid] < target) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return result;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        x = Integer.parseInt(split[1]);
        nums = new int[N + 1];

        split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i + 1] = Integer.parseInt(split[i]);
        }
    }
}
