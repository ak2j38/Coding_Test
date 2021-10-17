import java.io.*;
import java.util.ArrayList;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        int aIdx=1, bIdx = 1;
        for(int i=1; i<=N+M; i++){
            // A 배열이 하나도 안남은 경우
            if(aIdx == N+1){
                for(int j=bIdx; j<=M; j++)
                    sb.append(B[j]).append(" ");
                break;
            }

            // B 배열이 하나도 안남은 경우
            if(bIdx == M+1){
                for(int k=aIdx; k<=N; k++)
                    sb.append(A[k]).append(" ");
                break;
            }

            // 두 배열다 값이 있다면 값 비교해서 sb에 추가(더 작은 값이 있던 배열의 인덱스를 올린다)
            if(A[aIdx] > B[bIdx]) {
                sb.append(B[bIdx]).append(" ");
                bIdx++;
            }else {
                sb.append(A[aIdx]).append(" ");
                aIdx++;
            }
        }
        System.out.println(sb.toString());
    }


    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        A = new int[N+1];
        B = new int[M+1];
        split = br.readLine().split(" ");
        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(split[i - 1]);
        }
        split = br.readLine().split(" ");
        for(int i=1; i<=M; i++) {
            B[i] = Integer.parseInt(split[i - 1]);
        }
    }
}
