import java.util.ArrayList;
import java.util.Collections;

public class Solution {
        static ArrayList<String> candNums = new ArrayList<String>();
        static int[] selected, used;

    public static void main(String[] args) {
        int[] nums = {6, 10, 2};
        solution(nums);
    }

        public static String solution(int[] numbers) {
            String answer = "";
            int length = numbers.length;
            selected = new int[length+1];
            used = new int[length+1];

            rec_func(1, numbers, length);

            Collections.sort(candNums);

            answer = candNums.get(candNums.size()-1);

            return answer;
        }

        static void rec_func(int k, int[] A, int length){
            if(k == 4){
                String cand = "";
                for(int i=1; i<=A.length; i++)
                    cand += Integer.toString(A[i]);
                candNums.add(cand);
            }else{
                for(int cand=1; cand<=length; cand++){
                    if(used[cand] == 1) continue;
                    selected[k] = A[cand]; used[cand] = 1;
                    rec_func(k+1, A, length);
                    selected[k] = 0; used[cand] = 0;
                }
            }
        }
    }

