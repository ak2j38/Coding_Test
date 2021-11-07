import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int T, N, K, G;
    static int[] D, sum, indeg;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve(){
        // 각 테스트 케이스마다 정답을 도출해서 sb에 append하는 함수
        // 위상정렬을 하기위해 큐 선언 및 큐에 정점추가
        Deque<Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++){
            // indeg가 0인 점을 큐에 넣는다
            if(indeg[i] == 0) {
                que.add(i);
                sum[i] = D[i];
            }
        }

        // 위상정렬 실행하면서 순서를 어디에 저장해놓지?
        while(!que.isEmpty()){
            int x = que.poll();
            for(int y : adj[x]){
                indeg[y]--;
                if(indeg[y] == 0) que.add(y);
                sum[y] = Math.max(sum[y], sum[x] + D[y]);
            }
        }
        sb.append(sum[G]).append("\n");
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        T = Integer.parseInt(br.readLine());
        // 테스트 케이스만큼 반복
        for(int t=0; t<T; t++){
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            K = Integer.parseInt(split[1]);
            D = new int[N+1];
            sum = new int[N+1];
            indeg = new int[N+1];
            adj = new ArrayList[N+1];
            for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
            split = br.readLine().split(" ");
            int length = split.length;
            for(int j=0; j<length; j++){
                D[j+1] = Integer.parseInt(split[j]);
            }
            for (int i = 0; i < K; i++) {
                split = br.readLine().split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                adj[x].add(y);
                indeg[y]++;
            }
            G = Integer.parseInt(br.readLine());
            solve();
        }
    }
}

