import java.io.*;

public class Main {
    static int N, max, min;
    static int[] nums, operators;

    public static void main(String[] args) {
        try {
            input();

            rec_func(1, nums[1]);
            System.out.println(max);
            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rec_func(int k, int value){
        if(k == N){
            max = Math.max(max, value);
            min = Math.min(min, value);
        }else {
            for(int cand=1; cand<=4; cand++){
                if(operators[cand] >= 1){
                    operators[cand]--;
                    rec_func(k+1, calculator(value, cand, nums[k+1]));
                    operators[cand]++;
                }
            }
        }
    }

    static int calculator(int operand1, int operator, int operand2){
        if(operator == 1)
            return operand1 + operand2;
        else if(operator == 2)
            return operand1 - operand2;
        else if(operator == 3)
            return operand1 * operand2;
        else
            return operand1 / operand2;
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        nums = new int[N+1];
        operators = new int[5];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) nums[i+1] = Integer.parseInt(split[i]);
        split = br.readLine().split(" ");
        for(int i=0; i<4; i++) operators[i+1] = Integer.parseInt(split[i]);
    }

}
