import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N, M, K, spaceCnt;
    static int[][] adj, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    static ArrayList<Integer> spaceCntList = new ArrayList<>();

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
        Collections.sort(spaceCntList);

        System.out.println(spaceCntList.size());
        for (int num : spaceCntList) {
            System.out.print(num + " ");
        }
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (adj[i][j] != 1 && !visited[i][j]) {
                    dfs(i, j);
                    spaceCntList.add(spaceCnt);
                    spaceCnt = 0;
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        spaceCnt++;
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (adj[nx][ny] == 1) continue;
            if (visited[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File( "C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        K = Integer.parseInt(split[2]);

        adj = new int[N][M];
        visited = new boolean[N][M];
        spaceCnt = 0;

        // 0은 빈 공간, 1은 직사각형 영역
        for (int i = 0; i < K; i++) {
            split = br.readLine().split(" ");
            int startX = Integer.parseInt(split[1]);
            int startY = Integer.parseInt(split[0]);
            int endX = Integer.parseInt(split[3]);
            int endY = Integer.parseInt(split[2]);
            for (int x = startX; x < endX; x++) {
                for (int y = startY; y < endY; y++) {
                    adj[x][y] = 1;
                }
            }
        }
    }
}
