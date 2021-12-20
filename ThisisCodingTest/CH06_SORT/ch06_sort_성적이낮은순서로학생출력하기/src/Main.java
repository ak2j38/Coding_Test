import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int N;
    static Elem[] students;

    static class Elem implements Comparable<Elem> {
        String name;
        int grade;

        public Elem(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public int compareTo(Elem other) {
            return grade - other.grade;
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

    private static void solve() {
        Arrays.sort(students);

        for (Elem student : students) {
            System.out.print(student.name + " ");
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        N = Integer.parseInt(br.readLine());
        students = new Elem[N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            students[i] = new Elem(split[0], Integer.parseInt(split[1]));
        }
    }
}
