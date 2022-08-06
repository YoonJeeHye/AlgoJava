package week1_이상원;

import java.util.ArrayList;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42586
*/
public class 기능개발 {
    public static void main(String[] args) {
        int[] progress = {95, 90, 99, 99, 80, 99};
        int[] speeds = {4, 1, 1, 1, 1, 1};

        int[] days = new int[progress.length]; // 소요 시간 저장할 배열 생성
        for (int i = 0; i < progress.length; i++) {
            int isRemain = (100 - progress[i]) % speeds[i];
            int i1 = (100 - progress[i]) / speeds[i];
            days[i] = isRemain == 0 ? i1 : i1 + 1;
        }
        int maxDay = days[0]; // 최대 소요 날짜
        int cnt = 1; // 한번에 빠지는 progress 개수
        ArrayList<Integer> answer = new ArrayList<>(); // 정답 저장용
        for (int i = 1; i < days.length; i++) {
            if (maxDay < days[i]) {
                answer.add(cnt);
                cnt = 1;
                maxDay = days[i];
            } else {
                cnt++;
            }
        }
        answer.add(cnt);
        Object[] answer2 = answer.toArray();
//        return answer2;
    }
}
