import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] split = br.readLine().split(" ");
            System.out.println(Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
