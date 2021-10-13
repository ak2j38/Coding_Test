import java.io.*;

public class Main {
    static String str;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        str = str.trim();
        String[] split = str.split(" ");
        int answer = split.length;
        if(split[0].isEmpty() || split[0].isBlank())
            answer = 0;
        System.out.println(answer);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        str = br.readLine();
    }
}
