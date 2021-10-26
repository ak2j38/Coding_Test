import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static Elem[] students;

    static class Elem implements Comparable<Elem> {
        String name;
        int kor, eng, math;

        @Override
        public int compareTo(Elem other) {
            if (kor != other.kor) return other.kor - kor;
            if (eng != other.eng) return eng - other.eng;
            if (math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        Arrays.sort(students);
        for (Elem stu : students) System.out.println(stu.name);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        students = new Elem[N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            Elem a = new Elem();
            a.name = split[0];
            a.kor = Integer.parseInt(split[1]);
            a.eng = Integer.parseInt(split[2]);
            a.math = Integer.parseInt(split[3]);
            students[i] = a;
        }
    }
}
