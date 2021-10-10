import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static Integer[] nums;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        Arrays.sort(nums, Collections.reverseOrder());

        for(Integer num : nums)
            System.out.print(num);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split("");
        int length = split.length;
        nums = new Integer[length];
        for(int i=0; i<length; i++) nums[i] = Integer.parseInt(split[i]);
    }
}
