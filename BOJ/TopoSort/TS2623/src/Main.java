import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int N, M, cnt;
    static int[] indeg;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            solve();
            if(cnt == N) System.out.println(sb);
            else System.out.println(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        Deque<Integer> que = new LinkedList<>();
        cnt = 0;

        for(int i=1; i<=N; i++){
            if(indeg[i] == 0) que.add(i);
        }

        while(!que.isEmpty()){
            int x = que.poll();
            sb.append(x).append("\n");
            cnt++;
            for(int y : adj[x]){
                indeg[y]--;
                if(indeg[y] == 0) que.add(y);
            }
        }
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        adj = new ArrayList[N+1];
        indeg = new int[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
        for(int i=1; i<=M; i++){
            split = br.readLine().split(" ");
            int length = Integer.parseInt(split[0]);
            for(int j=1; j<=length; j++){
                // 첫 번째는 연결이 없다
                if(j == 1) continue;
                int x = Integer.parseInt(split[j-1]);
                int y = Integer.parseInt(split[j]);
                adj[x].add(y);
                indeg[y]++;
            }
        }
    }
}
