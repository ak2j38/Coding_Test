import java.io.*;
import java.util.ArrayList;

public class Main {
    // 일단 모두 입력받고 공식에 의해 트리를 구성하고 후위순회 해야겠다...
    static ArrayList<Integer> NUMS;
    static ArrayList<ArrayList<Integer>> TREE;


    public static void main(String[] args) {
        try {
            input();
            makeTree();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void makeTree(){
        // 트리 구성하는 메소드
        TREE = new ArrayList<>();
        for(int num : NUMS){

        }
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        NUMS = new ArrayList<>();
        while(true){
            String node = br.readLine();
            if(node == null) break;
            NUMS.add(Integer.parseInt(node));
        }
    }
}
