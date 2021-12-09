import java.io.*;

public class Main {
    static int H, M;
    static StringBuilder sb;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void solve() {
        // 경계값 먼저 처리하기
        if (M < 45) {
            if (H == 0) {
                sb.append(23).append(" ");
            } else {
                sb.append(H - 1).append(" ");
            }
            sb.append(String.format("%2d", (60 + (M - 45))));
        } else {
            sb.append(H).append(" ").append(M - 45);
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));
        sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        H = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
    }
}
