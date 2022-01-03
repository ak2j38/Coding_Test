import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int N;
    static Student[] Elem;
    static StringBuilder sb = new StringBuilder();

    static class Student implements Comparable<Student>{
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student other) {
            if (this.kor != other.kor) return other.kor - this.kor;
            else if (this.eng != other.eng) return this.eng - other.eng;
            else if (this.math != other.math) return other.math - this.math;
            return this.name.compareTo(other.name);
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
        Arrays.sort(Elem);

        for (Student student : Elem) {
            sb.append(student.name).append("\n");
        }

        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));


        N = Integer.parseInt(br.readLine());
        Elem = new Student[N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            String name = split[0];
            int kor = Integer.parseInt(split[1]);
            int eng = Integer.parseInt(split[2]);
            int math = Integer.parseInt(split[3]);
            Elem[i] = new Student(name, kor, eng, math);
        }
    }
}