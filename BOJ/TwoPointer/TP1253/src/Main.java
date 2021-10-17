import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean isValid(int target){
        int L=1, R=N;
        while(L<R){
            if(L == target) L++;
            else if(R == target) R--;
            else{
                if((nums[L]+nums[R]) == nums[target])
                    return true;
                else if(nums[target] > nums[L]+nums[R])
                    L++;
                else
                    R--;
            }
        }
        return false;
    }

    static void solve(){
        Arrays.sort(nums, 1, N+1);
        int answer = 0;
        // 3번째 요소부터 탐색하며 조건에 맞는 것이 있는지 찾는다
        for(int idx=1; idx<=N; idx++){
            if(isValid(idx))
                answer++;
        }
        System.out.println(answer);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        String[] split = br.readLine().split(" ");
        for(int i=1; i<=N; i++) nums[i] = Integer.parseInt(split[i-1]);
    }
}
