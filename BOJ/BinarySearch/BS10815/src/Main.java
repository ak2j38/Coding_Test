import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] cards, nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            solve();
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void binarySearch(int target){
        int L = 0, R = N-1;
        boolean flag = false;

        while(L <= R){
            int mid = (L+R)/2;

            if(cards[mid] <= target){
                // 타겟넘버 찾음
                if(target == cards[mid]){
                    sb.append(1).append(" ");
                    flag = true;
                    break;
                }
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        if(!flag)
            sb.append(0).append(" ");
    }

    static void solve(){
        // 이분탐색위해 정렬
        Arrays.sort(cards);

        for(int i=0; i<M; i++){
            binarySearch(nums[i]);
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++)
            cards[i] = Integer.parseInt(split[i]);
        M = Integer.parseInt(br.readLine());
        nums = new int[M];
        split = br.readLine().split(" ");
        for(int i=0; i<M; i++)
            nums[i] = Integer.parseInt(split[i]);
    }
}
