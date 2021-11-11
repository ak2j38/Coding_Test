import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        int answer = 0;

        for (int i=1; i<=N; i++) {
            if(i == 1000){
                break;
            }
            // case1) 100이하는 전부 한 수
            if (i < 100) {
                answer += 1;
            } else { // case2) 100부터는 각 자리 비교
                String num = String.valueOf(i);
                String[] split = num.split("");
                int first = Integer.parseInt(split[0]);
                int second = Integer.parseInt(split[1]);
                int third = Integer.parseInt(split[2]);
                if ((second - first) == (third - second)) {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
    }

}
