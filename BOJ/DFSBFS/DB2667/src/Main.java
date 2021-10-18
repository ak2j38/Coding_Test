import java.io.*;

public class Main {
    static int N;
    static int[][] homes;

    public static void main(String[] args) {

    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        homes = new int[N+1][N+1];
        for(int i=0; i<N; i++){

        }
    }
}
