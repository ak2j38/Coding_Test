import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    static ArrayList<String> candNums = new ArrayList<String>();
    static int[] selected, used;

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        solution(nums);
    }

    public static String solution(int[] numbers) {
        String answer = "";
        int length = numbers.length;
        selected = new int[length + 1];
        used = new int[length + 1];

        rec_func(1, numbers, length);

        Collections.sort(candNums);

        answer = candNums.get(candNums.size() - 1);
        System.out.println(answer);
        return answer;
    }

    static void rec_func(int k, int[] A, int length) {
        if (k == length+1) {
            String cand = "";
            for (int i = 1; i <= A.length; i++)
                cand += Integer.toString(selected[i]);
            candNums.add(cand);
        } else {
            for (int cand = 1; cand <= length; cand++) {
                if (used[cand] == 1) continue;
                selected[k] = A[cand-1]; used[cand] = 1;
                rec_func(k + 1, A, length);
                selected[k] = 0;       used[cand] = 0;
            }
        }
    }
}

