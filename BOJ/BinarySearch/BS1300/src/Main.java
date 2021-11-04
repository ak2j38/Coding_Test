import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static Long N, TARGET;
    static Long[] B;
    static ArrayList<Long> BL;

    public static void main(String[] args) {
        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int binarySearch(ArrayList<Integer> BL, int L, int R, int TARGET) {
        int res = 0;

        while(L<=R){
            int mid = (L+R)/2;

            if(BL.get(mid) <= TARGET){
                if(BL.get(mid) == TARGET){
                    res = mid;
                    break;
                }
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        return res;
    }

    static void solve(){
        Collections.sort(BL);

        int answer = binarySearch(BL, 0, (N*N)-1, TARGET);

        System.out.println(answer);
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Long.parseLong(br.readLine());
        TARGET = Long.parseLong(br.readLine());
        B = new Long[N*N];
        BL = new ArrayList<>();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                BL.add(i*j);
            }
        }
    }
}
