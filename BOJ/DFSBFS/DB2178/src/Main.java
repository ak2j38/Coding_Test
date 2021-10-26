import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, answer, min;
    static int[][] adj;
    static boolean[] visit;

    public static void main(String[] args) {
        try {
            input();
            bfs(0);
            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void bfs(int startx){
        Queue<Integer> que = new LinkedList<>();

        que.add(startx);
        visit[startx] = true;

        while(!que.isEmpty()){
            int x = que.poll();
            answer++;

            for(int y=0; y<M; y++){
                if(adj[x][y] == 0) continue;
                if(visit[y]) continue;

                que.add(y);
                visit[y] = true;
            }
        }
    }


    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        answer = 0;
        min = Integer.MAX_VALUE;
        visit = new boolean[M];
        adj = new int[N][M];
        for(int i=0; i<N; i++){
            split = br.readLine().split("");
            for(int j=0; j<M; j++){
                adj[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
