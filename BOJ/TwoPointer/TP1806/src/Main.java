import java.io.*;

public class Main {
    static int N, S;
    static int[] nums;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        int R=0, sum=0, answer=N+1;
        for(int L=1; L<=N; L++){
            // L - 1 을 구간에서 제외
            sum -= nums[L-1];

            // R을 옮길 수 있을 때 까지 옮기기
            while(R + 1 <= N && sum < S){
                R++;
                sum += nums[R];
            }

            // [L~R]의 합, 즉 sum이 조건을 만족하면 정답 갱신
            if(sum >= S)
                answer = Math.min(answer, R-L+1);
        }
        // answer값 불가능 체크
        if(answer == N+1)
            answer = 0;

        System.out.println(answer);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        nums = new int[N+1];
        split = br.readLine().split(" ");
        for(int i=1; i<=N; i++) nums[i] = Integer.parseInt(split[i-1]);
    }
}
