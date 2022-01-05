import java.io.*;

public class Main {

    static int N, K;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        long cnt = 0;
        int orgN = N;

        while (true) {
            String binaryString = Integer.toBinaryString(N);
            cnt = binaryString.chars()
                    .filter(ch -> ch == '1')
                    .count();

            if (cnt <= K) break;
            N++;
        }

        System.out.println(N - orgN);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
    }
}
