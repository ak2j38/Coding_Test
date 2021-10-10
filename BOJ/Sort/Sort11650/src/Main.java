import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static Elem[] pos;

    static class Elem implements Comparable<Elem>{
        public int x, y;

        @Override
        public int compareTo(Elem other){
            if(x != other.x) return x - other.x;
            return y - other.y;
        }
    }

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        Arrays.sort(pos);

        for(Elem a : pos)
            System.out.println(a.x + " " + a.y);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        pos = new Elem[N];
        for(int i=0; i<N; i++){
            String[] split = br.readLine().split(" ");
            Elem a = new Elem();
            a.x = Integer.parseInt(split[0]);
            a.y = Integer.parseInt(split[1]);
            pos[i] = a;
        }
    }
}
