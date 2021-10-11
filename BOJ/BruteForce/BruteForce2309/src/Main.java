import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N=9, M=7;
    static int[] heights, selected;
    static boolean find_answer_flag = false;

    public static void main(String[] args) {
        try {
            input();
            rec_func(1, 1, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rec_func(int k, int start, int value){
        if(find_answer_flag) return ;
        if(k == M+1){
            if(value == 100){
                find_answer_flag = true;
                Arrays.sort(selected);
                for(int height : selected)
                    if(height != 0){
                        sb.append(height).append("\n");
                    }
                System.out.println(sb);
            }
        }else{
            for(int cand=start; cand<=N; cand++){
                selected[k] = heights[cand];
                rec_func(k+1, cand+1, value + heights[cand]);
                selected[k] = 0;
            }
        }
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        heights = new int[N+1];
        selected = new int [M+1];
        for(int i=1; i<=N; i++) heights[i] = Integer.parseInt(br.readLine());
    }
}
