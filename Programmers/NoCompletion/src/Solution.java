import java.util.Arrays;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int length = participant.length;

        Arrays.sort(participant);
        Arrays.sort(completion);


        for(int i=0; i<length; i++){
            if(i == length - 1){
                answer = participant[length-1];
                break;
            }
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}