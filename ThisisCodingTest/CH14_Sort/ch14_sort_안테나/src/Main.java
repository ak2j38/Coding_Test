import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] houses;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void solve() {
        Arrays.sort(houses);

        if (N % 2 == 0) {
            System.out.println(houses[(houses.length / 2) - 1]);
        } else {
            System.out.println(houses[houses.length / 2]);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        N = Integer.parseInt(br.readLine());
        houses = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(split[i]);
        }
    }
}
