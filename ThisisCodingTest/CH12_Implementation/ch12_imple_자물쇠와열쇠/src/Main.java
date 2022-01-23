public class Main {

    public static void main(String[] args) {

        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));
    }

    // TODO : 회전, 이동, 체크
    private static boolean solution(int[][] key, int[][] lock) {

        return false;
    }

    static int[][] rotateKey(int[][] key, int dirCommand) {

        return key;
    }

    static int[][] moveKey(int[][] key, int dirCommand) {

        return key;
    }

    static boolean isFinish(int[][] key, int[][] lock) {

        return false;
    }
}
