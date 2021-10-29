import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String[][] vill;
    static int N, M, sX, sY, dX, dY;
    static int[][] adjWater, adjGo, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visitWater, visitGo;
    static ArrayList<Integer> waterFall = new ArrayList<>();

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print(){
        int answer = adjGo[dX][dY];
        if(answer == 0) System.out.println("KAKTUS");
        else System.out.println(answer);
    }

    static void bfsWater(){
        Queue<Integer> que1 = new LinkedList<>();

        int length = waterFall.size();
        if(length == 0){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++)
                    adjWater[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<length; i=i+2){
            que1.add(waterFall.get(i));
            que1.add(waterFall.get(i+1));
            visitWater[waterFall.get(i)][waterFall.get(i+1)] = true;
        }

        while(!que1.isEmpty()){
            int x = que1.poll();
            int y = que1.poll();

            for(int k=0; k<4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(!vill[nx][ny].equals(".")) continue;
                if(visitWater[nx][ny]) continue;

                que1.add(nx);
                que1.add(ny);
                visitWater[nx][ny] = true;
                adjWater[nx][ny] = adjWater[x][y] + 1;
            }
        }
    }

    static void bfsGo(){
        Queue<Integer> que = new LinkedList<>();

        que.add(sX);
        que.add(sY);
        visitGo[sX][sY] = true;

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();

            for(int k=0; k<4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visitGo[nx][ny]) continue;
                if(vill[nx][ny].equals("*") || vill[nx][ny].equals("X")) continue;
                if(adjWater[nx][ny] <= adjGo[x][y] + 1 && !vill[nx][ny].equals("D") && adjWater[nx][ny] != 0) continue;

                que.add(nx);
                que.add(ny);
                visitGo[nx][ny] = true;
                adjGo[nx][ny] = adjGo[x][y]+1;
            }
        }
    }

    static void solve(){
        bfsWater();
        bfsGo();
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        adjWater = new int[N][M]; adjGo = new int[N][M];
        vill = new String[N][M];
        visitWater = new boolean[N][M]; visitGo = new boolean[N][M];
        for(int i=0; i<N; i++){
            split = br.readLine().split("");
            for(int j=0; j<M; j++){
                if(split[j].equals("*")){
                    waterFall.add(i);
                    waterFall.add(j);
                } else if(split[j].equals("S")){
                    sX = i;
                    sY = j;
                } else if(split[j].equals("D")){
                    dX = i;
                    dY = j;
                }
                vill[i][j] = split[j];
            }
        }
    }
}
