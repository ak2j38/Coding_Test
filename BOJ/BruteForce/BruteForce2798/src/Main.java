import java.io.*;

public class Main {
    static int N, M, max;
    static int[] nums, selected, cands;

    public static void main(String[] args) {
        try {
            input();
            rec_func(1);
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rec_func(int k) {
        if(k == 4){
            int value = calc();
            if(value <= M) max = Math.max(max, value);
        }else{
            for(int cand=selected[k-1]+1; cand<=N; cand++){
                cands[k] = nums[cand]; selected[k] = cand;
                rec_func(k+1);
                cands[k] = 0; selected[k] = 0;
            }
        }
    }

    static int calc(){
        int sum = 0;
        for(int i=1; i<4; i++) sum+=cands[i];
        return sum;
    }

    static void input() throws FileNotFoundException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        max = Integer.MIN_VALUE;
        nums = new int[N+1]; selected = new int[N+1]; cands = new int[4];
        split = br.readLine().split(" ");
        for(int i=0; i<split.length; i++) nums[i+1] = Integer.parseInt(split[i]);
    }
}
