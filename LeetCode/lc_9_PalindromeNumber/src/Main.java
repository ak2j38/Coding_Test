public class Main {

    public static void main(String[] args) {

//        int x = 121;
//        int x = -121;
        int x = 10;

        boolean result = isPalindrome(x);
        System.out.println(result);
    }

    public static boolean isPalindrome(int x) {
        StringBuilder org = new StringBuilder().append(x);
        StringBuilder rev = new StringBuilder().append(x).reverse();

        if (org.toString().equals(rev.toString())) {
            return true;
        }
        return false;
    }
}
