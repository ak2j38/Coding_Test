import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parents;
    static Queue<Integer> que;

    public static void main(String[] args) {
        try {
            input();
            init();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void init() {
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static void solve() {
        while (!que.isEmpty()) {
            int point1 = que.poll();
            int point2 = que.poll();

            if (findParents(point1) != findParents(point2)) {
                unionParents(point1, point2);
            }
        }

        long count = Arrays.stream(parents)
                .filter(value -> value != 0)
                .distinct()
                .count();

        System.out.println(Arrays.toString(parents));
        System.out.println(count);
    }

    private static int findParents(int point) {
        if (parents[point] != point) {
            parents[point] = findParents(parents[point]);
        }
        return parents[point];
    }

    private static void unionParents(int point1, int point2) {
        point1 = findParents(point1);
        point2 = findParents(point2);

        if (point1 < point2) {
            parents[point1] = point2;
            int finalPoint = point1;
            parents = Arrays.stream(parents)
                    .filter(value -> value == parents[finalPoint])
                    .toArray();

        } else {
            parents[point2] = point1;
            int finalPoint = point2;
            parents = Arrays.stream(parents)
                    .filter(value -> value == parents[finalPoint])
                    .toArray();
        }
    }

    private static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        parents = new int[N + 1];
        que = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            que.add(Integer.parseInt(split[0]));
            que.add(Integer.parseInt(split[1]));
        }
    }
}
