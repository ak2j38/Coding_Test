import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N, M, answer;
    static String[] noHear, noSee;
    static ArrayList<String> noHearSee = new ArrayList<>();

    public static void main(String[] args) {
        try {
            input();
            binarySearch();
            printAnswer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void binarySearch(){
        Arrays.sort(noSee);

        for(int i=0; i<N; i++){
            answer += lower_bound(noSee, 0, M-1, noHear[i]);
        }
        Collections.sort(noHearSee);
    }

    static int lower_bound(String[] noSee, int L, int R, String find){
        while(L<=R){
            int mid = (L+R)/2;
            if(noSee[mid].compareTo(find) <= 0){
                if(noSee[mid].equals(find)){
                    noHearSee.add(find);
                    return 1;
                }
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return 0;
    }

    static void printAnswer(){
        System.out.println(answer);
        for(int i=0; i<noHearSee.size(); i++)
            System.out.println(noHearSee.get(i));
    }


    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        noHear = new String[N];
        noSee = new String[M];
        for(int i=0; i<N+M; i++){
            if(i < N) noHear[i] = br.readLine();
            else noSee[i-N] = br.readLine();
        }
    }
}
