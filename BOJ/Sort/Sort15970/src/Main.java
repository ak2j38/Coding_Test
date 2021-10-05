import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, sum;
    static Elem[] dots;
    static boolean[] used;

    static class Elem implements Comparable<Elem>{
        public int pos, color;

        @Override
        public int compareTo(Elem other){
            if(color != other.color) return color-other.color;
            return pos- other.pos;
        }

        @Override
        public String toString(){
            return pos+ " " + color;
        }
    }


    public static void main(String[] args) {
        try {
            input();
            solve();
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        Arrays.sort(dots);
        System.out.println(Arrays.toString(dots));
        for(int i=1; i<N; i++){
            if(dots[i-1].color == dots[i].color){
                sum += Math.min(Math.abs(dots[i-1].pos - dots[i].pos), Math.abs(dots[i+1].pos - dots[i].pos));
                used[i] = true;
            }
        }
        for(int i=N-2; i>1; i--){
            if(dots[i].color == dots[i-1].color){
                if(!used[i]){
                    sum +=  Math.min(Math.abs(dots[i-1].pos - dots[i].pos), Math.abs(dots[i+1].pos - dots[i].pos));
                }
            }
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        dots = new Elem[N];
        used = new boolean[N];
        for(int i=0; i<N; i++){
            String[] split = br.readLine().split(" ");
            dots[i] = new Elem();
            dots[i].pos = Integer.parseInt(split[0]);
            dots[i].color = Integer.parseInt(split[1]);
        }
    }


}
