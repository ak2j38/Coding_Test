import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) {
        try {
            input();
            solve();
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        Arrays.sort(A);
        for(int i=0; i<M; i++){
            sb.append(binarySearch(A, 0, N-1, B[i])).append(" ");
        }
    }

    static int binarySearch(int[] A, int L, int R, int X){
        // 이분탐색을 하면서 해당 숫자가 몇개 등장하는지 리턴해야한다
        // 몇 개 등장하는지는 마지막등장 - 처음등장을 하면 쉽게 나올 듯
        return upper_bound(A, L, R, X) - lower_bound(A, L, R, X);
    }

    static int lower_bound(int[] A, int L, int R, int X){
        // 숫자 중 가장 왼쪽 인덱스 리턴해야한다.
        int res = R + 1;
        while(L<=R){
            int mid = (L+R)/2;
            if(A[mid] >= X){
                res = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return res;
    }

    static int upper_bound(int[] arr, int L, int R, int X){
        // 숫자 중 가장 오른쪽 인덱스 리턴해야한다.
        int res = R + 1;
        while(L<=R){
            int mid = (L+R)/2;
            if(A[mid] > X){
                res = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return res;
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(split[i]);
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        split = br.readLine().split(" ");
        for(int i=0; i<M; i++) B[i] = Integer.parseInt(split[i]);
    }
}
