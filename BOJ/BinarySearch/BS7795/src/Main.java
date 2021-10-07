import java.io.*;
import java.util.Arrays;

public class Main {
    static int T, N, M, answer;
    static int[] A, B;

    public static void main(String[] args) {
        try {
            input();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solve(int[] arr, int L, int R, int X){
        // 배열에서 X미만의 수 중 가장 오른쪽 인덱스를 리턴한다(이유는 더 작은것들의 수를 세야하므로)
        // 없으면 L-1리턴
        int res = L-1;

        while(L<=R){
            int mid = (L+R)/2;
            if(arr[mid] < X){
                res = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return res+1;
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String split[] = br.readLine().split(" ");
            N = Integer.parseInt(split[0]); M = Integer.parseInt(split[1]); answer = 0;
            A = new int[N]; B = new int[M];
            split = br.readLine().split(" ");
            for(int j=0; j<N; j++) A[j] = Integer.parseInt(split[j]);
            split = br.readLine().split(" ");
            for(int k=0; k<M; k++) B[k] = Integer.parseInt(split[k]);
            Arrays.sort(B);

            for(int aIdx=0; aIdx<N; aIdx++){
                answer += solve(B, 0, M-1, A[aIdx]);
            }
            System.out.println(answer);
        }
    }
}
