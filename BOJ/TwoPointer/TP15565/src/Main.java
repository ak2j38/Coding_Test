import java.io.*;

public class Main {
    static int N, K;
    static int[] dolls;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        int R=0, sum_lions=0, answer = N+1;
        for(int L=1; L<=N; L++){
            if(dolls[L-1] == 1)
                sum_lions--;

            while(R+1<=N && sum_lions < K){
                R++;
                if(dolls[R] == 1){
                    sum_lions++;
                }
            }

            if(sum_lions >= K){
                answer = Math.min(answer, R-L+1);
            }
        }
        if(answer == N+1)
            answer = -1;
        System.out.println(answer);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        dolls = new int[N+1];
        split = br.readLine().split(" ");
        for(int i=1; i<=N; i++) dolls[i] = Integer.parseInt(split[i-1]);
    }
}
