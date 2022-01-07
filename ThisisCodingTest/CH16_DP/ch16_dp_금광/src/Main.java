import java.io.*;
import java.util.Arrays;

public class Main {
    static int T, n, m, sum, max;
    static int[][] goldmine, dir = {{-1, 1}, {0, 1}, {1, 1}};
    static boolean[][] visited;

    public static void main(String[] args) {
        try {
            input();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        // rec_func or dfs?
        for (int i = 0; i < n; i++) {
            sum = 0;
            sum += goldmine[i][0];
            visited[i][0] = true;
            dfs(i, 0, 1);
            visited[i][0] = false;
        }
        System.out.println(max);
    }

    private static void dfs(int x, int y, int moveCnt) {

        visited[x][y] = true;

        if (moveCnt == m + 1) {
            // 목적지 도착
            max = Math.max(max, sum);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(visited[i][j] + "   ");
                }
                System.out.println();
            }
            System.out.println("-----------------------------");
        } else {

            for (int k = 0; k < 3; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;

                // 재귀
                sum += goldmine[nx][ny];
                dfs(nx, ny, moveCnt++);
                visited[nx][ny] = false;
                sum -= goldmine[nx][ny];
            }
        }
    }

    private static void print() {
        System.out.println(Arrays.deepToString(goldmine));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);
            goldmine = new int[n][m];
            visited = new boolean[n][m];
            sum = 0;
            max = Integer.MIN_VALUE;

            split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    goldmine[j][k] = Integer.parseInt(split[(j * 4) + k]);
                }
            }
            solve();
            print();
        }
    }
}
