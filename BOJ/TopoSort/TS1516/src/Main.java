import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int N;
    static int[] D, Done, indeg;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        try {
            input();
            solve();
            for(int i=1; i<=N; i++) System.out.println(Done[i]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        Deque<Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indeg[i] == 0) que.add(i);
            Done[i] += D[i];
        }

        while(!que.isEmpty()){
            int x = que.poll();
            for(int y : adj[x]){
                indeg[y]--;
                Done[y] = Math.max(Done[y], Done[x]+D[y]);
                if(indeg[y] == 0){
                    que.add(y);
                }
            }
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        D = new int[N + 1];
        Done = new int[N + 1];
        indeg = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split(" ");
            int length = split.length;
            D[i] = Integer.parseInt(split[0]);
            for(int j=1; j<length; j++){
                int y = Integer.parseInt(split[j]);
                if(y == -1) continue;
                adj[y].add(i);
                indeg[i]++;
            }
        }
    }
}
