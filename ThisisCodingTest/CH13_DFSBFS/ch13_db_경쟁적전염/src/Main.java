import java.io.*;
import java.util.*;

public class Main {

    static int N, K, S, targetX, targetY;
    static int[][] examiners, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static class Virus implements Comparable<Virus> {
        int x;
        int y;
        int value;

        public Virus(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Virus o) {
            return this.value - o.value;
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

    private static void solve() {
        List<Virus> tempViruses = new ArrayList<>();
        Queue<Virus> virusQue = new LinkedList<>();

        // MultiSource BFS
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (examiners[i][j] != 0) {
                    tempViruses.add(new Virus(i, j, examiners[i][j]));
                }
            }
        }

        // 큐에 옮겨담기
        Collections.sort(tempViruses);
        for (Virus virus : tempViruses) {
            virusQue.add(virus);
        }

        // BFS
        for (int i = 0; i < S; i++) {
            int queSize = virusQue.size();
            for (int j = 0; j < queSize; j++) {
                Virus currentVirus = virusQue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = currentVirus.x + dir[k][0];
                    int ny = currentVirus.y + dir[k][1];

                    // 유효값 검사
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (examiners[nx][ny] != 0) continue;

                    examiners[nx][ny] = currentVirus.value;
                    virusQue.add(new Virus(nx, ny, currentVirus.value));
                }
            }
        }

        // 출력
        System.out.println(examiners[targetX - 1][targetY - 1]);
    }

    private static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        examiners = new int[N][N];

        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                examiners[i][j] = Integer.parseInt(split[j]);
            }
        }

        split = br.readLine().split(" ");
        S = Integer.parseInt(split[0]);
        targetX = Integer.parseInt(split[1]);
        targetY = Integer.parseInt(split[2]);
    }
}
