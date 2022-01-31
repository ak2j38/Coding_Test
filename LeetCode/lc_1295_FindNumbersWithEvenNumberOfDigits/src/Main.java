public class Main {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7869};

        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int result = 0;

        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                result++;
            }
        }

        return result;
    }
}
