public class Main {

    public static void main(String[] args) {
        System.out.println("123 = " + reverse(123));
        System.out.println("120 = " + reverse(120));
        System.out.println("-123 = " + reverse(-123));
        System.out.println("2147483647 = " + reverse(Integer.MAX_VALUE));
        System.out.println("-2147483648 = " + reverse(Integer.MIN_VALUE));
    }

    private static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        String reverseNum;
        if (x < 0) {
            sb.append(String.valueOf(x).substring(1)).append("-");
            reverseNum = sb.reverse().toString();
            if (Integer.MIN_VALUE > Long.parseLong(reverseNum)) {
                return 0;
            }
            return Integer.parseInt(reverseNum);
        }
        sb.append(x);
        reverseNum = sb.reverse().toString();
        if (Integer.MAX_VALUE - 1 < Long.parseLong(reverseNum)) {
            return 0;
        }
        return Integer.parseInt(reverseNum);
    }

//    Solution
//    public int reverse(int x) {
//        String ans = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
//                : new StringBuilder(String.valueOf(x)).reverse().toString();
//        try {
//            return Integer.parseInt(ans);
//        } catch (Exception e) {
//            return 0;
//        }
//    }
}
