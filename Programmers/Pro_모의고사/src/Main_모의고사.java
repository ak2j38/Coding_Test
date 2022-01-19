import java.util.ArrayList;
import java.util.Arrays;

public class Main_모의고사 {

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        System.out.println(Arrays.toString(solution(answers)));
        System.out.println(Arrays.toString(solution(answers2)));
    }

    static class Student implements Comparable<Student> {
        int index;
        int answerCnt;

        public Student(int index, int answerCnt) {
            this.index = index;
            this.answerCnt = answerCnt;
        }

        @Override
        public int compareTo(Student other) {
            return this.index - other.index;
        }
    }

    private static int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        ArrayList<Student> students = new ArrayList<>();

        Student st1 = new Student(1, 0);
        Student st2 = new Student(2, 0);
        Student st3 = new Student(3, 0);

        // 정답배열만큼 반복
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) {
                st1.answerCnt++;
            }
            if (answers[i] == two[i % two.length]) {
                st2.answerCnt++;
            }
            if (answers[i] == three[i % three.length]) {
                st3.answerCnt++;
            }
        }
        students.add(st1);
        students.add(st2);
        students.add(st3);
        int max = Math.max(st1.answerCnt, Math.max(st2.answerCnt, st3.answerCnt));

        return students.stream()
                .filter(student -> student.answerCnt == max)
                .mapToInt(student -> student.index)
                .sorted()
                .toArray();
    }
}

