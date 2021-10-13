import java.io.*;

public class Main {
    static int N, K, max;
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
        int R=0, sum=0;
        boolean flag = false;
        for(int L=1; L<=N; L++){
            flag = false;
            sum -= nums[L-1];

            while(R+1<=N && R-L+1 < K){
                sum+= nums[++R];
                flag = true;
            }
            if(flag)
                max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        max = Integer.MIN_VALUE;
        nums = new int[N+1];
        split = br.readLine().split(" ");
        for(int i=1; i<=N; i++)
            nums[i] = Integer.parseInt(split[i-1]);
    }

}
