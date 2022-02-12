import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        List<String> commands = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            parseLog(record[i], commands, userList);
        }

        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).equals("Enter")) {
                answer.add(userList.get(i).enter());
            } else if (commands.get(i).equals("Leave")) {
                answer.add(userList.get(i).leave());
            }
        }

        return answer.toArray(new String[answer.size()]);
    }

    static class User {
        private String userId;
        private String nickName;

        public User(String userId, String nickName) {
            this.userId = userId;
            this.nickName = nickName;
        }

        public String enter() {
            return this.nickName + "님이 들어왔습니다.";
        }

        public String leave() {
            return this.nickName + "님이 나갔습니다.";
        }

        public void changeNickName(String newNickName) {
            this.nickName = newNickName;
        }

        public boolean isSameUser(String userId) {
            if (this.userId.equals(userId)) {
                return true;
            }
            return false;
        }
    }

    public static void parseLog(String log, List<String> commands, List<User> userList) {
        String[] split = log.split(" ");

        String command = split[0];
        String userId = split[1];
        String nickName = "";
        if (!command.equals("Leave")) {
            nickName = split[2];
        }

        User findUser = findUser(userId, userList);
        if (findUser == null) {
            findUser = new User(userId, nickName);
        }
        if (command.equals("Change") || command.equals("Enter")) {
            findUser.changeNickName(nickName);
        }

        commands.add(command);
        userList.add(findUser);
    }

    public static User findUser(String userId, List<User> userList) {
        User findUser = null;

        for (User user : userList) {
            if (user.isSameUser(userId)) {
                findUser = user;
                break;
            }
        }

        return findUser;
    }
}
