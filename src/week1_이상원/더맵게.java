package week1_이상원;

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
        PriorityQueue<Integer> arr = new PriorityQueue<>();
        for (int num :
                scoville) {
            arr.offer(num);
        }

        while (arr.peek() <= k) {
            if (arr.size() == 1) {
                return;
            }
            int first = arr.poll();
            int second = arr.poll();

            int newScoville = first + (second * 2);
            arr.offer(newScoville);
            cnt++;
        }
        System.out.println(cnt);
    }
}