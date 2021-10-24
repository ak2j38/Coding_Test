import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] parent;

    public static void main(String[] args) {
        try {
            input();
            solve();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int x, int par){
        // 순회하면서 부모와 값이 같으면 컨티뉴, 다르면 그 값의 부모는 x
        for(int y : adj[x]){
            if(y == par) continue;
            parent[y] = x;
            dfs(y, x);
        }
    }

    static void solve(){
        dfs(1, -1);

        // 1번의 부모는 없으니까 2번부터 시작해야한다
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=1; i<N; i++){
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            adj[x].add(y);
            adj[y].add(x);
        }
    }
}
