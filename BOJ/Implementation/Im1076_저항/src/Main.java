import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static final int COLORS_CNT = 3;
    static List<String> colors = new ArrayList<>();

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        long num1 = getColorNum(colors.get(0));
        long num2 = getColorNum(colors.get(1));
        long multi = getColorMulti(colors.get(2));

        long answer = ((num1 * 10) + num2) * multi;

        System.out.println(answer);
    }

    private static int getColorNum(String color) {
        if (color.equals("black")) return 0;
        else if (color.equals("brown")) return 1;
        else if (color.equals("red")) return 2;
        else if (color.equals("orange")) return 3;
        else if (color.equals("yellow")) return 4;
        else if (color.equals("green")) return 5;
        else if (color.equals("blue")) return 6;
        else if (color.equals("violet")) return 7;
        else if (color.equals("grey")) return 8;
        return 9;
    }

    private static int getColorMulti(String color) {
        if (color.equals("black")) return 1;
        else if (color.equals("brown")) return 10;
        else if (color.equals("red")) return 100;
        else if (color.equals("orange")) return 1_000;
        else if (color.equals("yellow")) return 10_000;
        else if (color.equals("green")) return 100_000;
        else if (color.equals("blue")) return 1_000_000;
        else if (color.equals("violet")) return 10_000_000;
        else if (color.equals("grey")) return 100_000_000;
        return 1_000_000_000;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        for (int i = 0; i < COLORS_CNT; i++) {
            colors.add(br.readLine());
        }
    }
}
