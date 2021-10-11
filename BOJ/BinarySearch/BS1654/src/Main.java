import java.io.*;

public class Main {
    static int N, M;
    static int[] lines;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        // L R ans
        // 이분탐색과 determination 문제를 이용해서 answer 구하자
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        lines = new int[N];
        for(int i=0; i<N; i++) lines[i] = Integer.parseInt(br.readLine());
    }
}
