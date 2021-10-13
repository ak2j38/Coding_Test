import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, M, min;
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
        // 투 포인터 사용위해 정렬
        Arrays.sort(nums);

        int R=0, answer = Integer.MAX_VALUE;
        for(int L=1; L<=N; L++){
            // R 증가시키기
            while(R+1<=N && nums[R] - nums[L] < M){
                R++;
                answer = nums[R] - nums[L];
            }
            // 정답 갱신
            if(answer >= M)
                min = Math.min(min, answer);
        }
        System.out.println(min);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        min = Integer.MAX_VALUE;
        nums = new int[N+1];
        for(int i=1; i<=N; i++) nums[i] = Integer.parseInt(br.readLine());
    }
}
