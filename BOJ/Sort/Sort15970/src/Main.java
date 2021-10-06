import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, sum;
    static Elem[] dots;

    static class Elem implements Comparable<Elem>{
        public int pos, color;

        @Override
        public int compareTo(Elem other){
            if(color != other.color) return color-other.color;
            return pos- other.pos;
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

        for(int i=0; i<N; i++){
            int prev=0, next=0;
            if(i == 0){
                sum += Math.abs(dots[i].pos - dots[i+1].pos);
                continue;
            }
            if(i == N-1){
                sum += Math.abs(dots[i].pos - dots[i-1].pos);
                break;
            }
            if(dots[i].color == dots[i-1].color) prev = Math.abs(dots[i].pos - dots[i-1].pos);
            if(dots[i].color == dots[i+1].color) next = Math.abs(dots[i].pos - dots[i+1].pos);
            if(prev ==  0) sum += next;
            else if(next == 0) sum += prev;
            else sum += Math.min(prev, next);
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        N = Integer.parseInt(br.readLine());
        dots = new Elem[N];
        for(int i=0; i<N; i++){
            String[] split = br.readLine().split(" ");
            dots[i] = new Elem();
            dots[i].pos = Integer.parseInt(split[0]);
            dots[i].color = Integer.parseInt(split[1]);
        }
    }
}
