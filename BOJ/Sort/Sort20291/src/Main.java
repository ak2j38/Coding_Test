import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String[] exts;

    public static void main(String[] args) {
        try {
            input();
            solve();
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        Arrays.sort(exts);
        int sum = 1;
        for(int i=1; i<N; i++){
            if(exts[i].equals(exts[i-1])){
                sum++;
            } else{
                sb.append(exts[i-1]).append(" " +sum);
                sb.append("\n");
                sum = 1;
            }
            if(i == N-1) {
                sb.append(exts[i]).append(" " +sum).append("\n");
                break;
            }
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        exts = new String[N];
        for(int i=0; i<N; i++){
            String[] split = br.readLine().split("[.]");
            exts[i] = split[1];
        }
    }
}
