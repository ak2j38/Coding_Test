import java.io.*;
import java.util.ArrayList;

public class Main {
    static String S;
    static ArrayList<Character> cList;
    static StringBuilder sb;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        for(int i=97; i<=122; i++){
            sb.append(S.indexOf((char)i)).append(" ");
        }
        System.out.println(sb);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        S = br.readLine();
        sb = new StringBuilder();
    }

}
