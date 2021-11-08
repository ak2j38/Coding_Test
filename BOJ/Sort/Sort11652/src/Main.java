import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, min;
    static Elem[] cards;

    static class Elem implements Comparable<Elem>{
        public long num;
        public int cnt;

        @Override
        public int compareTo(Elem other){
            if(cnt != other.cnt) return other.cnt - cnt;
            return Long.valueOf(num).compareTo(other.num);
        }
    }

    public static void main(String[] args) {
        try {
            input();
            solve();
            if(cards.length > 1)
                System.out.println(cards[0].num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        Arrays.sort(cards);
        for(int i=1; i<N; i++){
            if(cards[i-1].num == cards[i].num){
                cards[i].cnt = 1 + cards[i-1].cnt;
            }else{
                cards[i].cnt = 1;
            }
        }
        Arrays.sort(cards);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        cards = new Elem[N];
        for(int i=0; i<N; i++){
            cards[i] = new Elem();
            cards[i].num = Long.parseLong(br.readLine());
            cards[i].cnt = 1;
        }
    }

}
