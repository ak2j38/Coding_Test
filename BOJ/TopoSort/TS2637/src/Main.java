import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static int[][] cnt; // x를 만드는 데 필요한 y 갯수
    static int[] indeg;
    static ArrayList<Part>[] adj;

    static class Part{
        int y, k;
        Part(int y, int k){
            this.y = y;
            this.k = k;
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
        Deque<Integer> que = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            if(indeg[i] == 0) {
               que.add(i);
               cnt[i][i] = 1;
            }
        }

        while(!que.isEmpty()){
            int x = que.poll();

            for(Part p : adj[x]){
                int y = p.y;
                int k = p.k;
                indeg[y]--;
                for(int i=1; i<=N; i++){
                    cnt[y][i] += cnt[x][i] * k;
                }
                if(indeg[y] == 0) que.add(y);
            }
        }

        for(int i=1; i<=N; i++){
            if(cnt[N][i] != 0) System.out.println(i + " " + cnt[N][i]);
        }
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        indeg = new int[N+1];
        adj = new ArrayList[N+1];
        cnt = new int[N+1][N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<M; i++){
            String[] split = br.readLine().split(" ");
            int y = Integer.parseInt(split[0]);
            int x = Integer.parseInt(split[1]);
            int k = Integer.parseInt(split[2]);
            adj[x].add(new Part(y, k));
            indeg[y]++;
        }
    }
}
