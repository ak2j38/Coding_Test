import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    static int N, M;
    static int[] reqs;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean determination(int value){
        // value 예산으로 집행했을 때 집행가능한가?
        long sum=0;
        for(int i=0; i<N; i++){
            if(reqs[i] >= value){
                sum += value;
            }else{
                sum += reqs[i];
            }
        }
        return sum <= M;
    }

    static void solve(){
        int L=0, R=1000000000, answer=0;

        // 모든 요청 가능하면 예산 중 최댓값 출력
        if(Arrays.stream(reqs).sum() <= M){
            answer = Arrays.stream(reqs).max().getAsInt();
            System.out.println(answer);
            return;
        }

        // 불가능하면 매개변수탐색 실행
        while(L<=R){
            int mid = (L+R)/2;
            if(determination(mid)){
                answer = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(answer);
    }


    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        reqs = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) reqs[i] = Integer.parseInt(split[i]);
        M = Integer.parseInt(br.readLine());
    }
}
