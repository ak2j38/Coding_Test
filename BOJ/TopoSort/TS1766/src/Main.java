import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i=1; i<=N; i++){
            if (indeg[i] == 0){
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            sb.append(x).append(" ");

            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0){
                    que.add(y);
                }
            }
        }
        System.out.println(sb);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        sb = new StringBuilder();
        indeg = new int[N+1];
        adj = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            adj[x].add(y);
            indeg[y]++;
        }
    }
}
