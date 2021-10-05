import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Elem[] words;

    static class Elem implements Comparable<Elem>{
        public String word;
        public int length;

        @Override
        public int compareTo(Elem other){
            if(length != other.length) return length - other.length;
            return word.compareTo(other.word);
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
        Arrays.sort(words);
        sb.append(words[0].word).append("\n"); // 첫 번째 값 넣어주기
        for(int i=1; i<N; i++){
            // 이전 값과 동일하지 않다면 추가
            if(!words[i].word.equals(words[i-1].word)) sb.append(words[i].word).append("\n");
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        words = new Elem[N];
        for(int i=0; i<N; i++) {
            words[i] = new Elem();
            words[i].word = br.readLine();
            words[i].length = words[i].word.length();
        }
    }
}
