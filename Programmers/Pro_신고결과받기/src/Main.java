import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
        System.out.println(Arrays.toString(solution(id_list2, report2, k2)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        // 1. User 클래스 생성?
        List<User> userList = new ArrayList<>();

        // 2. 유저리스트에 넣기
        for (String id : id_list) {
            userList.add(new User(id, 0));
        }

        // 3. 같은 유저한테 신고당한 것은 무효(중복 없애자)
        List<String> distinctReport = Arrays.stream(report)
                .distinct()
                .collect(Collectors.toList());

        for (String s : distinctReport) {
            String[] splitReport = s.split(" ");
            for (User user : userList) {
                if (user.isSameUser(splitReport[0])) {
                    user.addReportUser(splitReport[1]);
                }
                if (user.isSameUser(splitReport[1])) {
                    user.addReportCnt();
                }
            }
        }

        // 3.5 신고 임계점을 넘은 놈들 이름 리스트 뽑기
        List<String> blockUserList = userList.stream()
                .filter(user -> user.isBlockUser(k))
                .map(user -> user.getName())
                .collect(Collectors.toList());

        // 4. 자신이 신고해서 k가 넘는 것에만 카운트 업
        return userList.stream()
                .mapToInt(user -> user.getSuccessReportUserCount(blockUserList))
                .toArray();
    }

    static class User{
        String name;
        int reportCnt;
        List<String> reportUserNameList;

        public User(String name, int reportCnt) {
            this.name = name;
            this.reportCnt = reportCnt;
            this.reportUserNameList = new ArrayList<>();
        }

        public String getName() {
            return this.name;
        }

        public void addReportCnt() {
            this.reportCnt++;
        }

        public void addReportUser(String userName) {
            reportUserNameList.add(userName);
        }

        public boolean isSameUser(String name) {
            return this.name.equals(name);
        }

        public boolean isBlockUser(int k) {
            return reportCnt >= k;
        }

        public int getSuccessReportUserCount(List<String> blockUserList) {
            int successCnt = 0;
            for (String s : blockUserList) {
                if (reportUserNameList.indexOf(s) != -1) {
                    successCnt++;
                }
            }
            return successCnt;
        }
    }
}