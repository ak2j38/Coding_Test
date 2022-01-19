public class Main_이상한문자만들기 {

    public static void main(String[] args) {
        String s = "try hello world";

        System.out.println(solution(s));
    }

    private static String solution(String s) {
        String answer = "";

        int index = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                index = 0;
                answer += " ";
            } else if (index % 2 == 0) {
                answer += Character.toUpperCase(ch);
                index++;
            } else {
                answer += Character.toLowerCase(ch);
                index++;
            }
        }

        return answer;
    }
}
