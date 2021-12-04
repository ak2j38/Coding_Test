import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int T, N, M;
    static StringBuilder sb;
    static Queue<Document> que;

    static class Document implements Comparable<Document>{
        int index, pri;

        public Document(int index, int pri) {
            this.index = index;
            this.pri = pri;
        }

        @Override
        public int compareTo(Document other) {
            return other.pri - pri;
        }
    }

    public static void main(String[] args) {
        try {
            input();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {
        System.out.println(sb);
    }

    static void solve() {
        // 큐에서 뽑으면서 카운트한다
        int cnt = 0;

        while (true) {
            // 현재 최고 우선순위 값 Document
            Document maxPriDoc = que.stream().max(Document::compareTo).get();
            int max = que.stream().mapToInt(i -> i.pri).max().getAsInt();

            // 값이 최댓값인가?
            if (que.peek().pri == max) {
                if (que.peek().index == M) {
                    break;
                } else {
                    que.poll();
                    cnt++;
                    continue;
                }
            } else {
                que.add(que.poll());
            }
        }

        sb.append(cnt+1).append("\n");
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);
            que = new LinkedList<>();

            split = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                que.add(new Document(j, Integer.parseInt(split[j])));
            }
            solve();
        }
    }
}
