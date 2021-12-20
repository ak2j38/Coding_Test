import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N, K;
    static Integer[] A, B;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            A[i] = Math.max(A[i], B[i]);
        }
        System.out.println(Arrays.stream(A).mapToInt(value -> value).sum());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        A = new Integer[N];
        B = new Integer[N];

        split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
        split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            B[i] = Integer.parseInt(split[i]);
        }
    }
}
