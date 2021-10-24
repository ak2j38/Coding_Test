import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N;
    static ArrayList<String>[] adj;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            preOrder();
            inOrder();
            postOrder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void preOrder(){

    }

    static void inOrder(){

    }

    static void postOrder(){

    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for(int i=0; i<=N; i++) adj[i] = new ArrayList<>();
        for(int i=1; i<=N; i++){

        }
    }

}
