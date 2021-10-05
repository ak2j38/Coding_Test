import java.util.ArrayList;

public class Solution {
    static int N;
    static int[] used; // 사용했는지
    static String[] number, split; // 한 사이클로 완성된 숫자, 입력문자열 하나씩
    static ArrayList<Integer> answers = new ArrayList<>(); // 중복거르기 위한 리스트

    static int solution(String numbers){
        split = numbers.split("");
        N = split.length;

        for(int i=1; i<=N; i++){
            number = new String[N+1];
            used = new int[N+1];
            rec_func(1, i);
        }
        return answers.size();
    }

    static void rec_func(int k, int rec){
        if(k == rec+1){
            String num = "";
            for(String str : number){
                if(str != null)
                    num+=str;
            }
            int candNum = Integer.parseInt(num);
            // 리스트에 이미 있는지 확인
            if(!isExist(candNum))
                if(isPrime(candNum)){
                    // 리스트에 추가
                    answers.add(candNum);
                }
        }else{
            for(int cand=1; cand<=N; cand++){
                if(used[cand] == 1) continue;
                number[k] = split[cand-1]; used[cand] = 1;
                rec_func(k+1, rec);
                number[k] = null; used[cand] = 0;
            }
        }
    }

    static boolean isExist(int candNum){
        if(answers.contains(candNum))
            return true;
        return false;
    }

    static boolean isPrime(int candNum){
        // 0, 1 제외
        if(candNum==0 || candNum==1)  return false;

        // 소수 판별
        for(int i=2; i<candNum; i++)
            if(candNum%i==0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("17")); // 3
//        System.out.println(solution("011")); // 2
    }
}


