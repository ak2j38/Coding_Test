import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] P;
    static Elem[] a;

    static class Elem implements Comparable<Elem>{
        public int num, index;

        @Override
        public int compareTo(Elem other){
            // 여러가지 비교의 우선순위가 필요하다면 여기 추가
            // 이 문제에서는 stable해야 하지만 object형 비교는 기본적으로 stable해서 생략가능
            return num - other.num;
        }
    }

    public static void main(String[] args) {
        try {
            input();
            solve();
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        Arrays.sort(a);
        for(int i=0; i<N; i++) P[a[i].index] = i;
        for(int j=0; j<P.length; j++) sb.append(P[j]).append(" ");
        sb.append("\n");
    }

    static void input() throws FileNotFoundException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        a = new Elem[N];
        P = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            a[i] = new Elem();
            a[i].num = Integer.parseInt(split[i]);
            a[i].index = i;
        }
    }
}
