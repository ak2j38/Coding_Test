import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        String new_id1 = "...!@BaT#*..y.abcdefghijklm"; // bat.y.abcdefghi
        String new_id2 = "z-+.^.";                      // z--
        String new_id3 = "=.=";                         // aaa
        String new_id4 = "123_.def";                    // 123_.def
        String new_id5 = "abcdefghijklmn.p";            // abcdefghijklmn

        System.out.println(solution(new_id1));
        System.out.println(solution(new_id2));
        System.out.println(solution(new_id3));
        System.out.println(solution(new_id4));
        System.out.println(solution(new_id5));
    }

    public static String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase(Locale.ROOT);
        // 2단계
        new_id = new_id.replaceAll("[^\\w\\-_.]", "");
        // 3단계
        new_id = new_id.replaceAll("\\.{2,}", ".");
        // 4단계
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        // 5단계
        if (new_id.isBlank()) {
            new_id = "a";
        }
        // 6단계
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        // 7단계
        if (new_id.length() <= 2) {
            String lastWord = new_id.substring(new_id.length() - 1, new_id.length());
            while (new_id.length() < 3) {
                new_id = new_id.concat(lastWord);
            }
        }

        return new_id;
    }



}
