public class Main {

    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        String hand1 = "right";
        String hand2 = "left";
        String hand3 = "right";

        System.out.println(solution(numbers1, hand1)); // LRLLLRLLRRL
        System.out.println(solution(numbers2, hand2)); // LRLLRRLLLRR
        System.out.println(solution(numbers3, hand3)); // LLRLLRLLRL
    }

    private static String solution(int[] numbers, String hand) {
        final String leftHandType = "L";
        final String rightHandType = "R";

        StringBuilder sb = new StringBuilder();
        int currentLeftThumbPos = 10;
        int currentRightThumbPos = 12;

        for (int number : numbers) {
            if (number == 0) {
                number = 11;
            }

            if (number == 1 || number == 4 || number == 7) {
                sb.append(leftHandType);
                currentLeftThumbPos = number;
                continue;
            }
            if (number ==  3 || number == 6 || number == 9) {
                sb.append(rightHandType);
                currentRightThumbPos = number;
                continue;
            }
            int leftDistance = Math.abs(getDistanceFromKeyPad(currentLeftThumbPos, number));
            int rightDistance = Math.abs(getDistanceFromKeyPad(currentRightThumbPos, number));
            if (leftDistance == rightDistance) {
                String resultHand = getHandString(hand);
                if (resultHand.equals(leftHandType)) {
                    currentLeftThumbPos = number;
                } else {
                    currentRightThumbPos = number;
                }
                sb.append(resultHand);
            } else if (leftDistance > rightDistance) {
                sb.append(rightHandType);
                currentRightThumbPos = number;
            } else {
                sb.append(leftHandType);
                currentLeftThumbPos = number;
            }
        }
        return sb.toString();
    }

    private static int getDistanceFromKeyPad(int currentThumbPos, int targetPos) {
        // dist = ((현재 - 타겟) / 3) + ((현재 - 타겟) % 3)
        return ((currentThumbPos - targetPos) / 3) + ((currentThumbPos - targetPos) % 3);
    }

    private static String getHandString(String hand) {
        return hand.equals("left") ? "L" : "R";
    }
}
