import java.io.*;

public class Main {
    static StringBuilder A = new StringBuilder();
    static StringBuilder B = new StringBuilder();
    static StringBuilder sb = new StringBuilder();

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
        String aString = A.reverse().toString();
        String bString = B.reverse().toString();

        int maxLength = Math.max(aString.length(), bString.length());
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int aNum = 0;
            int bNum = 0;
            if (aString.length() > i) {
                aNum = Integer.parseInt(aString.substring(i, i + 1));
            }
            if (bString.length() > i) {
                bNum = Integer.parseInt(bString.substring(i, i + 1));
            }

            int sum = aNum + bNum + carry;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            sb.append(sum);
        }
        if (carry != 0) {
            sb.append(carry);
        }

        sb = sb.reverse();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        A.append(split[0]);
        B.append(split[1]);
    }
}
