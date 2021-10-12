import java.io.*;

public class Main {
    static int N, M;
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
        int R = 0, sum = 0, answer = 0;
        for(int L=1; L<=N; L++){
            sum -= nums[L-1];

            while (R + 1 <= N && sum < M) {
                R++;
                sum += nums[R];
            }

            if(sum == M)
                answer++;
        }
        System.out.println(answer);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        nums = new int[N + 1];
        split = br.readLine().split(" ");
        for(int i=1; i<=N; i++) nums[i] = Integer.parseInt(split[i-1]);
    }
}
