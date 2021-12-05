import java.io.*;

public class Main {
    static int[] nums;
    static int[] asc = {0,1,2,3,4,5,6,7,8};
    static int[] des = {0,8,7,6,5,4,3,2,1};

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        String answer = "";

        // 반복하며 확인
        for (int i=1; i<=8;  i++) {
            if (nums[i] == asc[i]) {
                answer = "ascending";
            } else if (nums[i] == des[i] && !answer.equals("ascending")) {
                answer = "descending";
            } else {
                answer = "mixed";
                break;
            }
        }
        System.out.println(answer);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        nums = new int[9];
        String[] split = br.readLine().split(" ");
        for (int i=0; i<8; i++) {
            nums[i+1] = Integer.parseInt(split[i]);
        }
    }
}
