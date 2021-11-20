import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N;
    static int[] A;
    static ArrayList<Integer> Da;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        Da.add(0);

        // 이분탐색해야한다
        for (int i=1; i<=N; i++) {
            // D의 마지막값보다 크면 add
            if (Da.get(Da.size()-1) < A[i]) {
                Da.add(A[i]);
            } else { // 아니면 이분탐색으로 들어갈 위치 정함
                int dIdx = binarySearch(1, Da.size()-1, A[i]);
                Da.set(dIdx, A[i]);
            }
        }
    }

    static int binarySearch(int L, int R, int TARGET) {
        // 무엇을 리턴하나? -> D배열의 인덱스
        int res = R; // 수정
        while (L < R) {
            int mid = (L + R) / 2;
            if (Da.get(mid) < TARGET) {
                L = mid + 1;
            } else {
                res = mid;
                R = mid;
            }
        }
        return res;
    }

    static void print() {
        System.out.println(Da.size()-1);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        Da = new ArrayList<>();
        String[] split = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            A[i+1] = Integer.parseInt(split[i]);
        }
    }
}
