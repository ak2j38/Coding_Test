import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"dog","racecar","car"};
//        String[] strs = {"a"};
//        String[] strs = {"car", "cir"};

        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int shortestLength = Arrays.stream(strs)
                .mapToInt(value -> value.length())
                .min()
                .getAsInt();

        StringBuilder sb = new StringBuilder();
        int correctCnt = 0;
        boolean flag = false;
        for (int i = 0; i < shortestLength; i++) {
            if (flag) break;
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) == strs[j + 1].charAt(i)) {
                    correctCnt++;
                    if (correctCnt == strs.length - 1) {
                        sb.append(strs[j].charAt(i));
                        correctCnt = 0;
                    }
                    continue;
                } else {
                    flag = true;
                    break;
                }
            }
        }
        return sb.toString();
    }
}
