import java.io.*;

public class Main {
    static int N, min;
    static int[][] S;
    static int[] selected, sTeam;

    public static void main(String[] args) {
        try {
            input();
            rec_func(1);
            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void rec_func(int k){
        if(k == (N/2)+1){
            min = Math.min(min, calcSum());
        }else{
            for(int cand=selected[k-1]+1; cand<=N; cand++){
                selected[k] = cand; sTeam[cand] = 1;
                rec_func(k+1);
                selected[k] = 0; sTeam[cand] = 0;
            }
        }
    }

    static int calcSum(){
        int sumStart=0, sumLink=0;
        for(int i=1; i<N; i++){
            for(int j=i+1; j<=N; j++){
                if(sTeam[i]==1 && sTeam[j]==1){
                    sumStart += (S[i][j] + S[j][i]);
                }else if(sTeam[i]==0 && sTeam[j]==0){
                    sumLink += (S[i][j] + S[j][i]);
                }
            }
        }
        return Math.abs(sumStart - sumLink);
    }

    static void input() throws FileNotFoundException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        S = new int[N+1][N+1];
        for(int i=0; i<N; i++){
            String[] split = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                S[i+1][j+1] = Integer.parseInt(split[j]);
            }
        }
        selected = new int[N/2+1];
        sTeam = new int[N+1];
    }

}
