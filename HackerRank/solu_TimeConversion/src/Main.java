import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Result2 {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String dayNight = s.substring(8, 10);
        int newHour = Integer.parseInt(s.substring(0, 2));

        if (dayNight.equals("PM") && newHour != 12) {
            newHour += 12;
        } else if (dayNight.equals("AM") && newHour == 12) {
            newHour = 00;
        }

        return String.format("%02d", newHour) + s.substring(2, 8);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String s = bufferedReader.readLine();

        String result = Result2.timeConversion(s);

        bufferedReader.close();
    }
}
