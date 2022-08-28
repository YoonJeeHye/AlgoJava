package week1.week1_이상원;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42626

*/
/*
 * 섞은 음식 스코빌 지수 : 가장 맵지 않은 스코빌 + (두 번째로 맵지 않은 스코빌 지수 * 2)
 */
public class 더맵게 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        int cnt = 0;
        PriorityQueue<Integer> arr = new PriorityQueue<>(); // 우선 순위 큐 사용
        for (int num :
                scoville) {
            arr.offer(num); // 우선순위 큐에 저장 최소 힙
        }

        while (arr.peek() <= k) { // root 값을 k와 비교해서 작거나 같을 때까지 반복
            if (arr.size() == 1) { // size가 1이면 만들 수 없는 경우
                return;
            }
            int first = arr.poll(); // root 반환
            int second = arr.poll(); // 다음 root 반환

            int newScoville = first + (second * 2); // 새로운 scoville 계산
            arr.offer(newScoville); // 우선순위 큐에 추가
            cnt++; // 새로 계산된 횟수 추가
        }
        System.out.println(cnt);
    }
}