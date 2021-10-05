import java.io.*;
import java.util.Arrays;

public class Main2 {
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

    static int calculator(int operand1, int operator, int operand2){
        // value, order[i], num[i+1]
        if (operator == 1) // +
            return operand1 + operand2;
        else if (operator == 2) // -
            return operand1 - operand2;
        else if (operator == 3) // *
            return operand1 * operand2;
        else // /
            return operand1 / operand2;
    }


    static void rec_func(int k, int value) {
        if (k == N) {
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            max = Math.max(max, value);
            min = Math.min(min, value);
            System.out.println("값 갱신 : max="+max+", min="+min);
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            for (int cand = 1; cand <= 4; cand++){
                if (operators[cand] >= 1){
                    operators[cand]--;
                    System.out.print("k="+k+", cand="+cand);
                    System.out.println(Arrays.toString(operators));
                    rec_func(k + 1, calculator(value, cand, nums[k + 1]));
                    operators[cand]++;
                    System.out.println("재귀탈출 :"+k+" "+ cand+" "+ Arrays.toString(operators));
                }
            }
        }
    }

    static void input() throws FileNotFoundException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        operators = new int[5];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<split.length; i++)
            nums[i+1] = Integer.parseInt(split[i]);
        split = br.readLine().split(" ");
        for(int i=0; i<split.length; i++)
            operators[i+1] = Integer.parseInt(split[i]);
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }
}
