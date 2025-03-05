import java.util.*;

public class Main {

    public static int solution(List<ArrayDeque<Integer>> students, int limitStudents) {

        int roomCount = 0;

        for (ArrayDeque<Integer> integers : students) { // 1~6 Grade
            int boyCnt = 0;
            int girlCnt = 0;

            while (!integers.isEmpty()) { // Grade students peeking
                int student = integers.pop();
                if (student == 0) {
                    girlCnt++;
                } else {
                    boyCnt++;
                }
            }

            roomCount += (girlCnt + limitStudents - 1) / limitStudents; // 여자 학생 방 개수
            roomCount += (boyCnt + limitStudents - 1) / limitStudents;  // 남자 학생 방 개수
        }

        return roomCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int countStudents = sc.nextInt();
        int limitStudents = sc.nextInt();
        // init List-List
        List<ArrayDeque<Integer>> students = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            students.add(new ArrayDeque<>());
        }

        for (int i = 0; i < countStudents; i++) {

            int gender = sc.nextInt();  // 성별 (0: 여자, 1: 남자)
            int grade = sc.nextInt();

            switch (grade) {
                case 1 : {
                    students.get(0).push(gender);
                    break;
                         }
                case 2 : {
                    students.get(1).push(gender);
                    break;
                }
                case 3 : {
                    students.get(2).push(gender);
                    break;
                         }
                case 4 : {
                    students.get(3).push(gender);
                    break;
                         }
                case 5 : {
                    students.get(4).push(gender);
                    break;
                }
                default : {
                    students.get(5).push(gender);
                    break;
                }
            }
        }

        System.out.println(solution(students, limitStudents));
    }
}
