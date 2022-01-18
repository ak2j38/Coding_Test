import java.util.*;

public class Main {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//    int N = 4;
//    int [] stages = {4,4,4,4,4};

        System.out.println(Arrays.toString(solution(N, stages))) ;
    }

    static class Fail implements Comparable<Fail>{
        int i;
        double failRate;

        public Fail(int i, double failRate) {
            this.i = i;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(Fail other) {
            return Double.compare(other.failRate, this.failRate);
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = {};
        List<Fail> fails = new ArrayList<>();

        int challenger = stages.length;
        for (int i = 1; i <= N; i++) {
            int stagePeopleCnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) {
                    stagePeopleCnt++;
                }
            }
            double fail = 0;
            if (challenger >= 1) {
                fail = ((double) stagePeopleCnt / (double) challenger);
            }

            fails.add(new Fail(i, fail));
            challenger -= stagePeopleCnt;
        }

        Collections.sort(fails);
        answer = fails.stream()
                .mapToInt(value -> value.i)
                .toArray();

        return answer;
    }
}
