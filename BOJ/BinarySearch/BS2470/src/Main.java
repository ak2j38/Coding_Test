import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] waters;
    static StringBuilder sb;

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
        System.out.println(sb);
    }

    static void solve() {
        // 이분탐색 활용을 위해 정렬하기
        Arrays.sort(waters, 1 , N+1);

        int closestZero = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        // 이분탐색을 조건에 맞게 호출하기
        for (int i=1; i<=N-1; i++) {
            // ary[i] 용액을 사용할 예정, ary[i]와 섞어서 0과 가장 가까운 용액을 오른쪽 구간에서 찾기
            // res는 ary[i]과 섞어볼 용액의 인덱스!
            int res = binarySearch(waters, i+1, N, -waters[i]);

            // ary[res-1] 과 ary[res] 중 ary[i]과 섞어서 더 0에 가까운 용액 찾기
            // case1) 범위가 맞는지 먼저 확인하고 섞어본 값을 확인한다
            if (i < res - 1 && Math.abs(waters[i] + waters[res-1]) < closestZero) {
                closestZero = Math.abs(waters[i] + waters[res-1]);
                v1 = waters[i];
                v2 = waters[res -1];
            }

            // case2) 범위가 맞는지 먼저 확인하고 섞어본 값을 확인한다
            if (res <= N && Math.abs(waters[i] + waters[res]) < closestZero) {
                closestZero = Math.abs(waters[i] + waters[res]);
                v1 = waters[i];
                v2 = waters[res];
            }
        }
        sb.append(v1).append(" ").append(v2);
    }

    static int binarySearch(int[] ary, int left, int right, int target) {
        // 배열에서 target 이상의 수 중 가장 왼쪽 인덱스를 return 하는 함수
        // 그런게 없다면 R+1 리턴
        int result = right+1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (ary[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        waters = new int[N+1];
        String[] split = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            waters[i+1] = Integer.parseInt(split[i]);
        }
    }
}
