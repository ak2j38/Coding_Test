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

    static boolean determination(long length){
        // length 높이로 잘랐을 때 N개 만큼을 얻을 수 있나?
        long sum = 0;
        for(int i=0; i<N; i++){
            if(lines[i] >= length){
                sum += lines[i] / length;
            }
        }
        return sum >= M;
    }

    static void solve(){
        // L R ans
        // 이분탐색과 determination 문제를 이용해서 answer 구하자
        long L = 0, R = Integer.MAX_VALUE, answer = 0;
        while(L <= R){
            long mid = (L+R)/2;
            if(determination(mid)){
                answer = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        lines = new int[N];
        for(int i=0; i<N; i++) lines[i] = Integer.parseInt(br.readLine());
    }
}
