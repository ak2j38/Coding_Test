import java.io.*;

public class Main {
    static int N, M, o_cnt, v_cnt;
    static String[][] adj;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[] answers;
    static boolean[][] visit;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        if(adj[x][y].equals("o")) o_cnt++;
        else if(adj[x][y].equals("v")) v_cnt++;

        for(int k=0; k<4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(adj[nx][ny].equals("#")) continue;
            if(visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void solve(){
        for(int x=0; x<N; x++){
            for(int y=0; y<M; y++){
                if(!visit[x][y] && !adj[x][y].equals("#")){
                    dfs(x, y);
                    if(o_cnt > v_cnt) answers[0] += o_cnt;
                    else answers[1] += v_cnt;
                    o_cnt = 0; v_cnt = 0;
                }
            }
        }
    }

    static void print(){
        for(int num : answers) System.out.print(num + " ");
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        adj = new String[N][M];
        visit = new boolean[N][M];
        answers = new int[2];

        for(int i=0; i<N; i++){
            split = br.readLine().split("");
            for(int j=0; j<M; j++){
                adj[i][j] = split[j];
            }
        }
    }
}
