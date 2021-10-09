import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, answer;
    static int[] nums;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        Arrays.sort(nums);

        for(int i=0; i<N; i++){
            for(int j=i; j>=0; j--){
                answer += nums[j];
            }
        }
        System.out.println(answer);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(split[i]);
    }

}
