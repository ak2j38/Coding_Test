import java.io.*;
import java.util.Arrays;

public class Main {
    static int N = 9;
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
        int max = Arrays.stream(nums).max().getAsInt();
        int index = 0;
        for(int i=0; i<N; i++){
            if(max == nums[i]) index = i+1;
        }
        System.out.println(max);
        System.out.println(index);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
    }
}
