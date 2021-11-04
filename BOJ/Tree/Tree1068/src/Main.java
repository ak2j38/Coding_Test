import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N, DEL;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        try {
            input();
            delNode(DEL);
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void delNode(int delNode){
        // 해당 노드가 지워지면 자식노드들도 전부 삭제된다
        for(int node : adj[delNode]){

            delNode(node);
        }
//        for(ArrayList<Integer> a : adj){
//            if(a == null) continue;
//            if(a.contains(delNode)) a.remove(Integer.valueOf(delNode));
//        }
        adj[delNode] = null;

    }

    static void solve(){
        // 단말 노드의 갯수를 세야한다.
        int leafNodeCnt = 0;
        for(int i=0; i<N; i++){
            if(adj[i] == null) continue;
            if(adj[i].size() == 0) leafNodeCnt++;
        }
        System.out.println(leafNodeCnt);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for(int i=0; i<N; i++) adj[i] = new ArrayList<>();
        String[] split = br.readLine().split(" ");
        int length = split.length;
        for(int i=0; i<length; i++){
            int iNum = Integer.parseInt(split[i]);
            // 루트노드 확인
            if(iNum == -1) continue;
            // 부모의 값에 index 넣기
            adj[iNum].add(i);
        }
        DEL = Integer.parseInt(br.readLine());
    }
}
