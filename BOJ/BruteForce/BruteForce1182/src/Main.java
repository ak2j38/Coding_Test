import java.io.*;

public class Main {
    static int N, M, answer;
    static int[] nums;

    public static void main(String[] args) {
        try {
            input();
            rec_func(1, 0);
            if(M == 0) answer--; // 진 부분집합 처리
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rec_func(int k, int value){
        if(k == N+1){
            if(value == M) answer++;
        }else{
            rec_func(k+1, value+nums[k]);
            rec_func(k+1, value);
        }
    }

    static void input() throws FileNotFoundException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        nums = new int[N + 1];
        split = br.readLine().split(" ");
        for(int i=0; i<split.length; i++) nums[i+1] = Integer.parseInt(split[i]);
    }
}
