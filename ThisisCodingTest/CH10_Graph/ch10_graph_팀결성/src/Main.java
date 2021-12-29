import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static int N, M;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        System.out.println(sb);
    }

    private static void unionTeam(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static int findParent(int student) {
        if (parent[student] != student) {
            parent[student] = findParent(parent[student]);
        }
        return parent[student];
    }

    private static void isSameTeam(int a, int b) {
        if (findParent(a) == findParent(b)) {
            sb.append("YES").append("\n");
        } else {
            sb.append("NO").append("\n");
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int command = Integer.parseInt(split[0]);
            int a = Integer.parseInt(split[1]);
            int b = Integer.parseInt(split[2]);

            if (command == 0) {
                // 팀 합치기 연산
                unionTeam(a, b);
            } else if (command == 1) {
                // 같은 팀 여부 확인
                isSameTeam(a, b);
            }
        }
    }
}
