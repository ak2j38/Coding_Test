import java.io.*;

public class Main {
    static int N, answer;
    static int[] frame;

    public static void main(String[] args) {
        try {
            input();
            rec_func(1);
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rec_func(int k){
        if(k == N+1){
            answer++;
        }else{
            for (int i = 1; i <= N; i++) {
                boolean possible = true;
                for(int j=1; j<=k-1; j++){
                    if(attackable(k, i, j, frame[j])){
                        possible = false;
                        break;
                    }
                }
                if(possible){
                    frame[k] = i;
                    rec_func(k + 1);
                    frame[k] = 0;
                }
            }
        }
    }

    static boolean attackable(int r1, int c1, int r2, int c2){
        if(r1 == r2 || c1 == c2) return true;
        if(r1+c1 == r2+c2) return true;
        if(r1-c1 == r2-c2) return true;
        return false;
    }

    static void input() throws FileNotFoundException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        frame = new int[N+1];
    }
}
