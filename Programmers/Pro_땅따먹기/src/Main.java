public class Main {
// 시간초과 - 실패
    static int result = 0;

    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        Main main = new Main();
        System.out.println("answer = " + main.solution(land));
    }

    int solution(int[][] land) {
        for (int i = 0; i < 4; i++) {
            rec_func(1, i, land, land[0][i]);
        }

        return result;
    }

    private void rec_func(int row, int prevCol, int[][] land, int sum) {
        if (row == land.length) {
            result = Math.max(result, sum);
        } else {
            for (int col = 0; col < 4; col++) {
                boolean isPossible = true;
                if (col == prevCol) {
                    isPossible = false;
                }

                if (isPossible) {
                    sum += land[row][col];
                    rec_func(row + 1, col, land, sum);
                    sum -= land[row][col];
                }
            }
        }
    }
}
