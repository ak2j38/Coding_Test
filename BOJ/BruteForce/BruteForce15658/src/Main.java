import java.io.*;

public class Main {
    static int N, max, min;
    static int[] operands, operators, selected;

    public static void main(String[] args) {
        try {
            input();
            rec_func(1, operands[1]);
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // N개의 숫자를 N-1개의 연산자로 계산해서 최댓값 최솟값 구하는 함수
    // 순열
    static void rec_func(int k, int value){
        if(k == N){
            max = Math.max(max, value);
            min = Math.min(min, value);
        }else{
            for(int cand=1; cand<=4; cand++){
                if(operators[cand] >= 1){
                    operators[cand]--;
                    rec_func(k+1, calc(cand, value, operands[k+1]));
                    operators[cand]++;
                }
            }
        }
    }

    static int calc(int operator, int operands1, int operands2){
        if(operator == 1) return operands1 + operands2;
        else if(operator == 2) return operands1 - operands2;
        else if(operator == 3) return operands1 * operands2;
        else return operands1 / operands2;
    }

    static void print(){
        System.out.println(max);
        System.out.println(min);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        operands = new int[N+1];
        operators = new int[5];
        selected = new int[5];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        String[] split = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            operands[i] = Integer.parseInt(split[i-1]);
        }
        split = br.readLine().split(" ");
        for(int i=1; i<=4; i++){
            operators[i] = Integer.parseInt(split[i-1]);
        }
    }
}
