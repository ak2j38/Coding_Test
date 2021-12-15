import java.io.*;

public class Main {

    public static void main(String[] args) {
        solve(input());
    }

    private static void solve(String knightPos) {
        // 나이트 row위치를 숫자로 변환
        int row = transferColPos(knightPos);
        int col = Integer.parseInt(knightPos.substring(1, 2));

        System.out.println(isCanMove(row, col));
    }

    private static int isCanMove(int row, int col) {
        int dir[][] = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        int canMoveCnt = 0;
        for (int k = 0; k < 8; k++) {
            int nx = row + dir[k][0];
            int ny = col + dir[k][1];

            if (nx < 1 || ny < 1 || nx > 8 || ny > 8) continue;
            canMoveCnt++;
        }
        return canMoveCnt;
    }

    private static int transferColPos(String knightPos) {
        String col = knightPos.substring(0, 1);
        if (col.equals("a")) return 1;
        else if (col.equals("b")) return 2;
        else if (col.equals("c")) return 3;
        else if (col.equals("d")) return 4;
        else if (col.equals("e")) return 5;
        else if (col.equals("f")) return 6;
        else if (col.equals("g")) return 7;
        else if (col.equals("h")) return 8;
        return 0;
    }

    static String input() {
        BufferedReader br;
        String knightPos = "";
        try {
            br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));
            knightPos = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return knightPos;
    }
}