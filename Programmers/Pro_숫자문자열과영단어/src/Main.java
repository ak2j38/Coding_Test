import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String s1 = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }

    public static int solution(String s) {
        List<String> numList = new ArrayList<>();
        numList.add("zero");
        numList.add("one");
        numList.add("two");
        numList.add("three");
        numList.add("four");
        numList.add("five");
        numList.add("six");
        numList.add("seven");
        numList.add("eight");
        numList.add("nine");

        for (int i = 0; i < numList.size(); i++) {
             if (s.contains(numList.get(i))) {
                 s = s.replace(numList.get(i), String.valueOf(i));
             }
        }

        return Integer.parseInt(s);
    }
}
