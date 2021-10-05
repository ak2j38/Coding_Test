import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    public static void main(String[] args) {
        try {
            input();

            rec_func(1);
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rec_func(int k) {
        if(k == M+1){
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append("\n");
        }else{
            for(int cand=selected[k-1]+1; cand<=N; cand++){
                selected[k] = cand;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    static void input() throws FileNotFoundException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        selected = new int[M+1];
    }


}
