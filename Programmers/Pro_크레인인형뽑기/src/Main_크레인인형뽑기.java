import java.util.Stack;

public class Main_크레인인형뽑기 {

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    private static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    if (basket.size() > 0 && basket.peek() == board[i][move - 1]) {
                        answer += 2;
                        basket.pop();
                    } else {
                        basket.push(board[i][move - 1]);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
