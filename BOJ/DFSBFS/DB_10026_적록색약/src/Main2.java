import java.io.*;

public class Main2 {

    static int N;
    static char map[][], map2[][];
    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };

    // 정상
    public static void dfs(int x, int y, char col) {
        // 방문 처리
        map[x][y] = 'X';

        for (int d = 0; d < 4; d++) {
            int xx = x + dx[d];
            int yy = y + dy[d];
            // 범위를 넘어가면 pass
            if (xx < 0 || yy < 0 || xx >= N || yy >= N) continue;
            // 이미 방문한 곳이면 pass
            if (map[xx][yy] == 'X') continue;
            // 색이 있는데 다른 색이면 pass
            if (col != map[xx][yy]) continue;
            dfs(xx, yy, map[xx][yy]);
        }
    }

    // 적록색약
    public static void dfs2(int x, int y, char col) {
        // 방문 처리
        map2[x][y] = 'X';

        for (int d = 0; d < 4; d++) {
            int xx = x + dx[d];
            int yy = y + dy[d];
            // 범위를 넘어가면 pass
            if (xx < 0 || yy < 0 || xx >= N || yy >= N) continue;
            // 이미 방문한 곳이면 pass
            if (map2[xx][yy] == 'X') continue;
            // 색이 있는데 다른 색이면 pass
            if (col != map2[xx][yy]) continue;
            dfs2(xx, yy, map2[xx][yy]);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];    // 정상
        map2 = new char[N][N];    // 적록색약
        for (int i = 0; i < N; i++) {
            String in = br.readLine();
            for (int j = 0; j < N; j++) {
                // 정상
                map[i][j] = in.charAt(j);
                // 적록색약: 빨간색과 초록색의 차이를 거의 느끼지 못한다 (G일 경우 R로 저장)
                if (in.charAt(j) == 'G')  map2[i][j] = 'R';
                else map2[i][j] = in.charAt(j);
            }
        }

        int cnt = 0; // 정상
        int cnt2 = 0;    // 적록색약
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 정상 : 방문하지 않은 곳이면
                if (map[i][j] != 'X') {
                    dfs(i, j, map[i][j]);
                    cnt++;
                }
                // 적록색약 : 방문하지 않은 곳이면
                if (map2[i][j] != 'X') {
                    dfs2(i, j, map2[i][j]);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt + " " + cnt2);
    }
}

