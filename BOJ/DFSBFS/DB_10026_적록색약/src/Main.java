import java.io.*;

public class Main {

    static int N;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static String[][] normalAdj, redGreenAdj;
    static boolean[][] visited1, visited2;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        // 적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
        int normalSpaceCount = 0;
        int redGreenSpaceCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 영역 구하기
                // 일반인 DFS
                if (!visited1[i][j]) {
                    dfs(i, j, normalAdj[i][j], false);
                    normalSpaceCount++;
                }
                if (!visited2[i][j]) {
                    // 적록색인 DFS
                    dfs(i, j, redGreenAdj[i][j], true);
                    redGreenSpaceCount++;
                }
            }
        }

        System.out.println(normalSpaceCount + " " + redGreenSpaceCount);
    }

    private static void dfs(int x, int y, String colorName, boolean isRedGreen) {
        if (isRedGreen) {
            visited2[x][y] = true;
        } else {
            visited1[x][y] = true;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            // 적록색인 분기 - 적록색인이면 R, G 동일 취급
            if (isRedGreen) {
                if (visited2[nx][ny]) continue;
                if (!redGreenAdj[nx][ny].equals(colorName)) continue;
                dfs(nx, ny, redGreenAdj[nx][ny], isRedGreen);
            } else {
                if (visited1[nx][ny]) continue;
                if (!normalAdj[nx][ny].equals(colorName)) continue;
                dfs(nx, ny, normalAdj[nx][ny], isRedGreen);
            }
        }
    }

    private static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        normalAdj = new String[N][N];
        redGreenAdj = new String[N][N];
        visited1= new boolean[N][N];
        visited2= new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                normalAdj[i][j] = split[j];
                if (split[j].equals("R") || split[j].equals("G")) {
                    redGreenAdj[i][j] = "A";
                } else {
                    redGreenAdj[i][j] = split[j];
                }
            }
        }
    }
}
