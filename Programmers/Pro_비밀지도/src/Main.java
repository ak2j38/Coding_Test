import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n1 = 5;
        int[] arr11 = {9, 20, 28, 18, 11};
        int[] arr21 = {30, 1, 21, 17, 28};

        int n2 = 6;
        int[] arr12 = {46, 33, 33, 22, 31, 50};
        int[] arr22 = {27, 56, 19, 14, 14, 10};

        System.out.println(Arrays.toString(solution(n1, arr11, arr21)));
        System.out.println(Arrays.toString(solution(n2, arr12, arr22)));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            String firstBinary = setSizeToN(Integer.toBinaryString(arr1[i]), n);
            String secondBinary = setSizeToN(Integer.toBinaryString(arr2[i]), n);
            String binary = andOperation(firstBinary, secondBinary, n);
            answer[i] = convertToSharp(binary);
        }
        return answer;
    }

    private static String andOperation(String firstBinary, String secondBinary, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (firstBinary.charAt(i) == '0' && secondBinary.charAt(i) == '0') {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
        return sb.toString();
    }

    private static String setSizeToN(String toBinaryString, int length) {
        if (toBinaryString.length() < length) {
            int needMoreSize = length - toBinaryString.length();
            for (int i = 0; i < needMoreSize; i++) {
                toBinaryString = "0" + toBinaryString;
            }
        }
        return toBinaryString;
    }

    private static String convertToSharp(String binary) {
        return binary.replaceAll("1", "#").replaceAll("0", " ");
    }
}
