import java.io.*;
import java.util.ArrayList;

public class Main {
    static int W, H, land_cnt;
    static int[][] adj, dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    static ArrayList<Integer> answers;
    static boolean[][] visit;

    public static void main(String[] args) {
        try {
            input();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print(){
        for(int num : answers) System.out.println(num);
    }

    // 내가 처음에 시도했던 방식은 섬의 갯수를 구하는것이 아니라 섬을 구성하는 땅의 갯수였다....
    static void solve() {
        land_cnt = 0;
        for(int i=0; i<W; i++){
            for(int j=0; j<H; j++){
                if(!visit[i][j] && adj[i][j] == 1){
                    land_cnt++;
                    dfs(i, j);
                }
            }
        }
        answers.add(land_cnt);
    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        for(int k=0; k<8; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if(nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
            if(adj[nx][ny] == 0) continue;
            if(visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }


    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));
        answers = new ArrayList<>();

        while(true){
            String[] split = br.readLine().split(" ");
            if(split[0].equals("0") && split[1].equals("0")) break;

            W = Integer.parseInt(split[0]);
            H = Integer.parseInt(split[1]);
            adj = new int[W][H];
            visit = new boolean[W][H];
            for(int i=0; i<H; i++){
                split = br.readLine().split(" ");
                for(int j=0; j<W; j++){
                    adj[j][i] = Integer.parseInt(split[j]);
                }
            }
            solve();
        }
    }
}
