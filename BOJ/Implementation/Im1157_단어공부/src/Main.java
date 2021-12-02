import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

public class Main {
    static String WORD, ANSWER;
    static HashMap<String, Integer> alphabetCnt;
    static ArrayList<String> CANDIDATES;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {
        System.out.println(ANSWER);
    }

    static void solve() {
        WORD = WORD.toUpperCase(Locale.ROOT);

        for (String str : WORD.split("")) {
            if (alphabetCnt.containsKey(str)) {
                alphabetCnt.put(str, alphabetCnt.get(str)+1);
            } else {
                alphabetCnt.put(str, 1);
            }
        }

        int maxValue = Collections.max(alphabetCnt.values());
        for (String key : alphabetCnt.keySet()) {
            if (alphabetCnt.get(key) == maxValue) {
                CANDIDATES.add(key);
            }
        }

        if (CANDIDATES.size() > 1) {
            ANSWER = "?";
        } else {
            ANSWER = CANDIDATES.get(0);
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        WORD = br.readLine();
        alphabetCnt = new HashMap<>();
        CANDIDATES = new ArrayList<>();
    }
}
