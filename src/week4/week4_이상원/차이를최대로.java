package week4.week4_이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 차이를최대로 {
    static int N, listSum, maxSum;
    static int[] line, numSet;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // N개의 정수 받아오기
        line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // N개의 수

        visited = new boolean[N]; // 순열에 사용될 방문 배열 초기화
        numSet = new int[N]; // 생성될 숫자 배열 초기화
        maxSum = Integer.MIN_VALUE; // 최대값 초기화

        // abs(a0 - a1) + abs(a1 - a2) ... abs(a n-2 - a n-1) 을 구하라
        // 순열을 사용해야 할 거 같다

        perm(0); // 순열 만들기 시작
        System.out.println(maxSum);
    }

    static void perm(int cnt) {
        if (cnt == N) {
            // 식을 구셩해야 함
            listSum = 0; // 생성된 순열을 계산할 숫자
            for (int i = 0; i < N - 1; i++) {
                listSum += Math.abs(numSet[i] - numSet[i + 1]); // 주어진 식
            }
            maxSum = Math.max(maxSum, listSum); // 최대 값을 갱신
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                numSet[cnt] = line[i];
                visited[i] = true;

                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
