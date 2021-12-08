import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] yuts;
    static StringBuilder sb;

    public static void main(String[] args) {
        try {
            input();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void solve() {
        int yutCnt = Arrays.stream(yuts).sum();
        if (yutCnt == 4) sb.append("E").append("\n");
        else if (yutCnt == 3) sb.append("A").append("\n");
        else if (yutCnt == 2) sb.append("B").append("\n");
        else if (yutCnt == 1) sb.append("C").append("\n");
        else if (yutCnt == 0) sb.append("D").append("\n");
    }

    static void input() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));
        sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            yuts = new int[4];
            String[] split = br.readLine().split(" ");
            yuts[0] = Integer.parseInt(split[0]);
            yuts[1] = Integer.parseInt(split[1]);
            yuts[2] = Integer.parseInt(split[2]);
            yuts[3] = Integer.parseInt(split[3]);

            solve();
        }
    }
}
