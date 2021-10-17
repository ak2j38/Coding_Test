import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static Elem[] members;

    static class Elem implements Comparable<Elem>{
        public int age;
        public String name;

        @Override
        public int compareTo(Elem other){
            return this.age - other.age;
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
        Arrays.sort(members);

        for(Elem member : members)
            System.out.println(member.age + " " + member.name);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        members = new Elem[N];
        for(int i=0; i<N; i++){
            String[] split = br.readLine().split(" ");
            Elem member = new Elem();
            member.age = Integer.parseInt(split[0]);
            member.name = split[1];
            members[i] = member;
        }
    }
}
