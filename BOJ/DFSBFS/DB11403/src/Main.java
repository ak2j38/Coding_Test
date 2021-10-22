import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] adj;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();

        // 초기화 과정 매우 중요
        for(int i=0; i<N; i++) visit[i] = 0;

        que.add(start);
        visit[start] = 0; // 자기 자신을 돌아올 수 있는지 판단해야 되므로 0

        while(!que.isEmpty()){
            int x = que.poll();

            for(int y=0; y<N; y++){
                if(adj[x][y] == 0) continue;
                if(visit[y] == 1) continue;

                que.add(y);
                visit[y] = 1;
            }
        }

        for(int i=0; i<N; i++){
            sb.append(visit[i]).append(" ");
        }
        sb.append("\n");
    }

    static void solve(){
        // bfs를 한 줄 당 한번 돌면 visit배열에 들어갈 값들이 채워질 것이다
        // 그러면 한 줄 당 visit배열을 출력하면 되지 않을까 ?
        for(int i=0; i<N; i++){
            bfs(i);
        }
    }

    static void print(){
        System.out.println(sb);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        visit = new int[N];
        for(int i=0; i<N; i++){
            String[] split = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                adj[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
