import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;

        System.out.println(solution(food_times, k));
    }

    public static int solution(int[] food_times, long k) {
        int answer = 0;
        Queue<Food> que = new LinkedList<>();

        for (int i = 1; i <= food_times.length; i++) {
            que.add(new Food(i, food_times[i - 1]));
        }

        for (int i = 0; i < k; i++) {
            if (que.isEmpty()) {
                break;
            }
            Food currentFood = que.poll();

            if (currentFood.foodTime > 1) {
                currentFood.foodTime -= 1;
                que.add(currentFood);
            }
        }

        if (que.isEmpty()) {
            answer = -1;
        } else {
            answer = que.poll().index;
        }

        return answer;
    }

    public static class Food {
        int index;
        int foodTime;

        public Food(int index, int foodTime) {
            this.index = index;
            this.foodTime = foodTime;
        }
    }
}
