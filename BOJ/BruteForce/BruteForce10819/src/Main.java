import java.io.*;

public class Main {
    static int N, max;
    static int[] nums, selected, used;

    public static void main(String[] args) {
        try {
            input();
            rec_func(1);
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rec_func(int k){
        if(k == N+1) {
            // calc 함수를 통해 식의 값을 구하고 max 갱신
            max = Math.max(max, calc());
        }else{
            for(int cand=1; cand<=N; cand++){
                if(used[cand]==1) continue;
                selected[k] = nums[cand]; used[cand] = 1;
                rec_func(k+1);
                selected[k] = 0; used[cand] = 0;
            }
        }
    }

    static int calc(){
        int sum = 0;
        for(int i=3; i<=N+1; i++){
            sum += Math.abs(selected[i-2] - selected[i-1]);
        }
        return sum;
    }

    static void input() throws FileNotFoundException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        nums = new int[N+1]; selected = new int[N+1];  used = new int[N+1];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) nums[i+1] = Integer.parseInt(split[i]);
    }
}
