import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M=6;           // 입력값, 뽑을 갯수
    static int[] nums;           // 입력받은 숫자배열(N+1)
    static boolean[] visited;    // 뽑은 여부

    public static void main(String[] args) {
        try {
            solve();
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rec_func(int k, int start){
        if(k == M+1){
            for(int i=1; i<=N; i++){
                if(visited[i])
                    sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
        }else{
            for(int cand=start; cand<=N; cand++){
                if(visited[cand]) continue;
                visited[cand] = true;
                rec_func(k+1, cand+1);
                visited[cand] = false;
            }
        }
    }

    static void solve() throws FileNotFoundException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        while(true){
            String nextLine = br.readLine();
            if(nextLine.equals("0")) break;
            String[] split = nextLine.split(" ");
            N = Integer.parseInt(split[0]);
            nums = new int[N+1];
            visited = new boolean[N+1];
            for(int i=1; i<=N; i++) nums[i] = Integer.parseInt(split[i]);
            rec_func(1, 1);
            sb.append("\n");
        }
    }
}
