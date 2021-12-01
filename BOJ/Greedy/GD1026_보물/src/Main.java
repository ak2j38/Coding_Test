import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N, ANSWER;
    static Integer[] A, B;

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
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i=0; i<N; i++) {
            ANSWER += A[i] * B[i];
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        A = new Integer[N];
        B = new Integer[N];
        String[] split = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(split[i]);
        }
        split = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            B[i] = Integer.parseInt(split[i]);
        }
    }
}
