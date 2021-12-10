import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

public class Main {
    static int N;
    static HashMap<String, Integer> books;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        int max = Integer.MIN_VALUE;
        for (String bookName : books.keySet()) {
            max = Math.max(max, books.get(bookName));
        }

        ArrayList<String> bookNameList = new ArrayList<>(books.keySet());
        Collections.sort(bookNameList);
        for (String bookName : bookNameList) {
            if (books.get(bookName) == max) {
                System.out.println(bookName);
                break;
            }
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        books = new HashMap<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String bookName = br.readLine();

            if (books.containsKey(bookName)) {
                books.put(bookName, books.get(bookName) + 1);
            } else {
                books.put(bookName, 1);
            }
        }
    }
}
