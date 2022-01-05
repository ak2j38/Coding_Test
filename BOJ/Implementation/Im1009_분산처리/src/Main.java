import java.io.*;

public class Main {
    static int T, a, b;
    static StringBuilder sb = new StringBuilder();

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
        int result = getMathPowLastNumber(a, b);

        if (result == 0) {
            sb.append(10).append("\n");
        } else {
            sb.append(result).append("\n");
        }
    }

    private static int getMathPowLastNumber(int targetNum, int powNum) {
        int orgFirstNum = targetNum % 10;
        int resultNum = targetNum % 10;

        for (int i = 2; i <= powNum; i++) {
            resultNum = (resultNum * orgFirstNum) % 10;
        }

        return resultNum;
    }

    private static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            a = Integer.parseInt(split[0]);
            b = Integer.parseInt(split[1]);

            solve();
        }
    }
}
