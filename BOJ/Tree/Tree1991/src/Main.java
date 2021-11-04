import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N;
    static ArrayList<String>[] adj;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            preOrder("A");
            sb.append("\n");
            inOrder("A");
            sb.append("\n");
            postOrder("A");
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void preOrder(String node){
        // 자기먼저 그다음 왼쪽자식 없으면 오른쪽자식
        sb.append(node);
        for(int i=1; i<=N; i++) {
            // 본인찾기
            if (adj[i].get(0).equals(node)) {
                // 왼쪽 // 오른쪽
                if (!adj[i].get(1).equals(".")) preOrder(adj[i].get(1));
                if (!adj[i].get(2).equals(".")) preOrder(adj[i].get(2));
            }
        }
    }

    static void inOrder(String node){
        // 왼쪽자식 루트 오른쪽 자식
        for(int i=1; i<=N; i++){
            // 본인찾기
            if(adj[i].get(0).equals(node)){
                // 왼쪽 // 오른쪽
                if (!adj[i].get(1).equals(".")) inOrder(adj[i].get(1));
                sb.append(node);
                if (!adj[i].get(2).equals(".")) inOrder(adj[i].get(2));
            }
        }
    }

    static void postOrder(String node){
        // 왼쪽자식 오른쪽 자식 루트
        for(int i=1; i<=N; i++){
            // 본인찾기
            if(adj[i].get(0).equals(node)){
                // 왼쪽 // 오른쪽
                if (!adj[i].get(1).equals(".")) postOrder(adj[i].get(1));
                if (!adj[i].get(2).equals(".")) postOrder(adj[i].get(2));
                sb.append(node);
            }
        }
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for(int i=0; i<=N; i++) adj[i] = new ArrayList<>();
        for(int i=1; i<=N; i++){
            String[] split = br.readLine().split(" ");
            for(String str : split){
                    adj[i].add(str);
            }
        }
    }
}
