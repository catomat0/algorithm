import java.io.*;

public class Main {

    public static String solution(int num, String seat) {
        int people = 0, cupHolder = 0;
        StringBuilder sb = new StringBuilder();
        String newSeat = seat.replace("LL", "L");

        // 컵홀더 추가한 문자열로 변환
        for (int i = 0; i < newSeat.length(); i++) {
            if (newSeat.charAt(i) == 'S') {
                sb.append("*S");
            } else {
                sb.append("*LL");
            }
        }
        sb.append("*");

        // 인원 측정
        String answer = sb.toString();
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == '*') {
                cupHolder++;
            } else {
                people++;
            }
        }

        return Math.min(people, cupHolder) + "";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String seat = br.readLine();

        bw.write(solution(num, seat));
        bw.flush();
        bw.close();
    }

    // 9 SLLLLSSLL -> *S*LL*LL*S*S*LL* - 7
    // 4 SLLS -> *S*LL*S* - 4
    // 3 SSS -> *S*S*S* - 3
}
