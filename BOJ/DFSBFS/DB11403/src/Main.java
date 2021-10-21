import java.io.*;

public class Main {
    static int N;
    static int[][] adj;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean dfs(int x, int y){

    }

    static void solve(){
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                if(dfs(i, j)) {
                    adj[i][j] = 1;
                    adj[j][i] = 1;
                }
            }
        }
    }

    static void print(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        for(int i=0; i<N; i++){
            String[] split = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                adj[i][j] = Integer.parseInt(split[j]);
            }
        }
    }

}
