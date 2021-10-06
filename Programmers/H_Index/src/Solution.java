import java.util.Arrays;

public class Solution implements Comparable<int>{

    @Override
    public int compareTo(int other){

    }


    static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));

        // 각 수에 대해서 전체반복한다
        // 변수 hIndex, 이상인용, 이하인용
        for(int i=0; i<citations.length; i++){
            int plus=0, minus=0;
            for(int j=0; j<citations.length; j++){
                // 이때 이상인용, 이하인용 citations[i] 같다면 이것이 hIndex

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] input = {3, 0, 6, 1, 5}; //[25, 8, 5, 3, 3] 3  [10, 8, 5, 4, 3] 4
        System.out.println(solution(input)); // 기댓값 3
    }
}
