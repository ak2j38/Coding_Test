import java.io.*;

public class Main {
    static int N;
    static int[] nums, cnt;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        int R=0;
        long answer = 0;
        for(int L=1; L<=N; L++){
            // R 범위 조정
            while(R+1<=N && cnt[nums[R+1]] == 0){
                R++;
                cnt[nums[R]]++;
            }
            // 정답 갱신
            answer += R-L+1;
            // L제외
            cnt[nums[L]]--;
        }
        System.out.println(answer);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1]; cnt = new int[100000+1];
        String[] split = br.readLine().split(" ");
        for(int i=1; i<=N; i++) nums[i] = Integer.parseInt(split[i-1]);
    }
}
