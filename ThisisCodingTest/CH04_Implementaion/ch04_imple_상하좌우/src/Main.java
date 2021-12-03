import java.io.*;

public class Main {
    static int N;
    static String[] COMMANDS;

    static class Traveler {
        int xPos, yPos;

        public Traveler(int x, int y) {
            this.xPos = x;
            this.yPos = y;
        }

        public Traveler movePos(Traveler t, String command) {
            if (command.equals("L") && isPossibleMove(t.xPos, t.yPos - 1)) {
                t.yPos -= 1;
                return t;
            } else if (command.equals("R") && isPossibleMove(t.xPos, t.yPos + 1)) {
                t.yPos += 1;
                return t;
            } else if (command.equals("U") && isPossibleMove(t.xPos - 1, t.yPos)) {
                t.xPos -= 1;
                return t;
            } else if (command.equals("D") && isPossibleMove(t.xPos + 1, t.yPos)) {
                t.xPos += 1;
                return t;
            }
            return t;
        }

        boolean isPossibleMove(int x, int y) {
            if (x < 1 || y < 1 || x > N || y > N) return false;
            return true;
        }
    }

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        Traveler A = new Traveler(1, 1);

        // 커맨드에 따라 여행
        for (String command : COMMANDS) {
            A.movePos(A, command);
        }

        System.out.println(A.xPos + " " + A.yPos);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        COMMANDS = br.readLine().split(" ");
    }
}
