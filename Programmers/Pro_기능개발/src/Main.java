import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] progresses1 = {93, 30, 55};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds1 = {1, 30, 5};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(main.solution(progresses1, speeds1))); // 2 1
        System.out.println(Arrays.toString(main.solution(progresses2, speeds2))); // 1 3 2
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Feature> features = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            features.add(new Feature(progresses[i], speeds[i]));
        }

        int day = 1;
        while (!isAllFeatureEnd(features)) {
            for (Feature feature : features) {
                feature.progressDay(day);
            }
            day++;
        }

        return calculateEndDay(features);
    }

    private int[] calculateEndDay(List<Feature> features) {
        List<Integer> endDayList = new ArrayList<>();

        int endCount = 0;
        int currentEndDay = 0;
        for (Feature feature : features) {
            if (currentEndDay == 0) {
                currentEndDay = feature.endDay;
                endCount++;
                continue;
            }
            if (feature.endDay <= currentEndDay) {
                endCount++;
                continue;
            } else {
                endDayList.add(endCount);
                endCount = 1;
                currentEndDay = feature.endDay;
            }
        }
        endDayList.add(endCount);
        return endDayList.stream()
                .mapToInt(value -> value)
                .toArray();
    }

    class Feature {
        int currentProgress;
        int speed;
        int endDay;

        public Feature(int currentProgress, int speed) {
            this.currentProgress = currentProgress;
            this.speed = speed;
            this.endDay = 0;
        }

        public void progressDay(int day) {
            if (!isEndWork()) {
                this.currentProgress += this.speed;
            }
            if (isEndWork() && endDay == 0) {
                this.endDay = day;
            }
        }

        public boolean isEndWork() {
            return this.currentProgress >= 100;
        }

        @Override
        public String toString() {
            return "Feature{" +
                    "currentProgress=" + currentProgress +
                    ", speed=" + speed +
                    ", endDay=" + endDay +
                    '}';
        }
    }

    private boolean isAllFeatureEnd(List<Feature> features) {
        for (Feature feature : features) {
            if (!feature.isEndWork()) {
                return false;
            }
        }
        return true;
    }
}
