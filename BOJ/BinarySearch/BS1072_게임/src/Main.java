import java.io.*;

public class Main {
    static long X, Y, Z, ANSWER;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        //  승률 99 이상일 경우 리턴
        if (Z >= 99) {
            ANSWER = -1;
            return;
        }

        // 매개변수 탐색으로 승률이 변하는 구간을 찾아야 한다
        long L = 1;
        long R = X;

        while (L <= R) {
            long mid = (L + R) / 2;
            if (getWinRate(X+mid, Y+mid) > Z) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        ANSWER = L;
    }

    static long getWinRate(long AllGame, long WinGame) {
        return (WinGame * 100) / AllGame;
    }

    static void print() {
        System.out.println(ANSWER);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        X = Long.parseLong(split[0]);
        Y = Long.parseLong(split[1]);
        Z = (Y*100) / X;
        ANSWER = 0;
    }
}
