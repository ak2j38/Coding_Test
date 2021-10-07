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
            sb.append(binarySearch(A, 0, N-1, B[i])).append("\n");
        }
    }

    static int binarySearch(int[] A, int L, int R, int X){
        int res = 0;
        while(L<=R){
            int mid = (L+R)/2;
            if(A[mid] < X) L = mid + 1;
            else R = mid - 1;

            if(A[mid] == X) return 1;
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
