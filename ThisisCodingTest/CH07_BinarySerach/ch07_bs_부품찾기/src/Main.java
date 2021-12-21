import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] AN, AM;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        Arrays.sort(AN);
        Arrays.sort(AM);

        for (int target : AM) {
            sb.append(binarySearch(0, N, target, AN)).append(" ");
        }

        System.out.println(sb);
    }

    private static String binarySearch(int L, int R, int target, int[] AN) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (AN[mid] == target) return "yes";
            if (AN[mid] < target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return "no";
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        AN = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            AN[i] = Integer.parseInt(split[i]);
        }
        M = Integer.parseInt(br.readLine());
        AM = new int[M];
        split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            AM[i] = Integer.parseInt(split[i]);
        }
    }
}
