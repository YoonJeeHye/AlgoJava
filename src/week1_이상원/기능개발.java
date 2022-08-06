package week1_이상원;

import java.util.ArrayList;
import java.util.Arrays;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42586
*/
public class 기능개발 {
    public static void main(String[] args) {
        int[] progress = {95, 90, 99, 99, 80, 99};
        int[] speeds = {4, 1, 1, 1, 1, 1};

        int[] days = new int[progress.length]; // 소요 시간 저장할 배열 생성
        for (int i = 0; i < progress.length; i++) { // 반복을 돌면서
            int isRemain = (100 - progress[i]) % speeds[i];  // 각 task에 필요한 날짜 계산을 위한 나머지 계산
            int i1 = (100 - progress[i]) / speeds[i]; // 필요한 시간 계산 => 몫
            days[i] = isRemain == 0 ? i1 : i1 + 1; // 나머지가 0이면 그대로 몫을 사용, 아니면 +1
        }
        int maxDay = days[0]; // 최대 소요 날짜
        int cnt = 1; // 한번에 빠지는 progress 개수
        ArrayList<Integer> answer = new ArrayList<>(); // 정답 저장용
        for (int i = 1; i < days.length; i++) {
            if (maxDay < days[i]) { // 현재 필요한 최대 날짜보다 크면
                answer.add(cnt); // 현재까지의 task 개수 정답 배열에 저장
                cnt = 1; // count 1로 초기화
                maxDay = days[i]; // 최대 필요 날짜 갱신
            } else {
                cnt++; // task 하나 추가
            }
        }
        answer.add(cnt); // 마지막에 계산된 count 저장
        Object[] answer2 = answer.toArray();
        System.out.println(Arrays.toString(answer2));
//        return answer2;
    }
}
