import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static Player player;
    static int[][] map;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        // 1은 바다 0은 육지 2는 가본 곳
        map[player.xPos][player.yPos] = 2;

        while (true) {
            turnLeft();
            // 현재 방향 기준으로 왼쪽부터 갈 수 있으면 간다
            if (isCanMove()) {
                moveForward();
            } else {
                // 이미 가본 칸이거나 바다인 경우
                if(isVisitedOrSea()) {
                    // 뒤가 바다면 멈춘다
                    if (isBackSea()) break;
                    // 뒤로 한 칸
                    moveBackward();
                    continue;
                }
            }
        }
        System.out.println(getMoveCnt());
    }

    private static int getMoveCnt() {
        int retCnt = 0;
        for(int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if(map[i][j] == 2) retCnt++;
            }
        }
        return retCnt;
    }


    private static boolean isVisitedOrSea() {
        if ((map[player.xPos - 1][player.yPos] == 1 || map[player.xPos - 1][player.yPos] == 2)
                && (map[player.xPos][player.yPos + 1] == 1 || map[player.xPos][player.yPos + 1] == 2)
                && (map[player.xPos + 1][player.yPos] == 1 || map[player.xPos + 1][player.yPos] == 2)
                && (map[player.xPos][player.yPos - 1] == 1 || map[player.xPos][player.yPos - 1] == 2)
            ) return true;
      return false;
    }

    private static void moveBackward() {
        if (player.dir == 0) {
            player.xPos += 1;
        } else if (player.dir == 1) {
            player.yPos -= 1;
        } else if (player.dir == 2) {
            player.xPos -= 1;
        } else if (player.dir == 3) {
            player.yPos += 1;
        }
    }

    private static void turnLeft() {
        if (player.dir == 0) player.dir = 3;
        else if (player.dir == 1) player.dir = 0;
        else if (player.dir == 2) player.dir = 1;
        else if (player.dir == 3) player.dir = 2;
    }

    private static void moveForward() {
        if (player.dir == 0) {
            map[player.xPos - 1][player.yPos] = 2;
            player.xPos -= 1;
        } else if (player.dir == 1) {
            map[player.xPos][player.yPos + 1] = 2;
            player.yPos += 1;
        } else if (player.dir == 2) {
            map[player.xPos + 1][player.yPos] = 2;
            player.xPos += 1;
        } else if (player.dir == 3) {
            map[player.xPos][player.yPos - 1] = 2;
            player.yPos -= 1;
        }
    }

    private static boolean isCanMove() {
        if (player.dir == 0) return map[player.xPos - 1][player.yPos] == 0;
        else if (player.dir == 1) return map[player.xPos][player.yPos + 1] == 0;
        else if (player.dir == 2) return map[player.xPos + 1][player.yPos] == 0;
        return map[player.xPos][player.yPos - 1] == 0;
    }

    private static boolean isBackSea() {
        if (player.dir == 0) return map[player.xPos + 1][player.yPos] == 1;
        else if (player.dir == 1) return map[player.xPos][player.yPos - 1] == 1;
        else if (player.dir == 2) return map[player.xPos - 1][player.yPos] == 1;
        return map[player.xPos][player.yPos + 1] == 1;
    }

    static class Player {
        int xPos, yPos, dir;

        public Player(int x, int y, int d) {
            this.xPos = x;
            this.yPos = y;
            this.dir = d;
        }
    }

    static void input() throws IOException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);
        map = new int[row][col];

        split = br.readLine().split(" ");
        player = new Player(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));

        for (int i = 0; i < row; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
