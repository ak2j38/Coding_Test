import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, M, answer=0;
    static int[] nums;

    public static void main(String[] args) {
        try {
            input();
            binarySearch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void binarySearch(){
        Arrays.sort(nums);

        for(int i=0; i<N; i++) {
            answer += lower_bound(nums, 0, N-1, nums[i], M);
        }
        System.out.println(answer/2);
    }

    static int lower_bound(int[] A, int L, int R, int X, int M){
        while(L<=R) {
            int mid = (L+R)/2;
            if(nums[mid]+X <= M){
               if(nums[mid]+X == M)
                   return 1;
               L = mid + 1;
            }else{
               R = mid - 1;
            }
        }
        return 0;
    }

    static void input() throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        String[] split = br.readLine().split(" ");
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(split[i]);
        M = Integer.parseInt(br.readLine());
    }
}
