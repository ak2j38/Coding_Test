import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] win_nums2 = {38, 19, 20, 40, 15, 25};
        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};

        System.out.println(Arrays.toString(solution(lottos, win_nums)));
        System.out.println(Arrays.toString(solution(lottos2, win_nums2)));
        System.out.println(Arrays.toString(solution(lottos3, win_nums3)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] nonZeroLottos = Arrays.stream(lottos)
                .filter(value -> value != 0)
                .toArray();

        int correctCnt = 0;
        for (int win_num : win_nums) {
            for (int nonZeroLotto : nonZeroLottos) {
                if (win_num == nonZeroLotto) {
                    correctCnt++;
                }
            }
        }
        
        // 최고순위 구하기 (0개 갯수 + 나머지 숫자에서 맞는 수)
        int zeroCnt = (int)Arrays.stream(lottos)
                .filter(value -> value == 0)
                .count();
        int maxRank = getRank(zeroCnt + correctCnt);
        // 최저 순위 구하기 (나머지 숫자에서 맞는 수)
        int minRank = getRank(correctCnt);

        return new int[]{maxRank, minRank};
    }

    private static int getRank(int correctNumbers) {
        if (correctNumbers == 6) {
            return 1;
        }
        if (correctNumbers == 5) {
            return 2;
        }
        if (correctNumbers == 4) {
            return 3;
        }
        if (correctNumbers == 3) {
            return 4;
        }
        if (correctNumbers == 2) {
            return 5;
        }
        return 6;
    }
}
