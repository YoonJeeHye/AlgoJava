package week3_이상원;

import java.util.ArrayDeque;
import java.util.Queue;

public class 가장먼노드 {static int cnt;

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        // n * n 테이블에 무향 그래프를 넣는다
        boolean[][] table = new boolean[ n + 1][n + 1]; // 각 노드의 연결을 나타낼 배열
        boolean[] visited = new boolean[n + 1]; // 방문 여부 확인용

        for (int[] ints : edge) { // 주어진 배열을 가지고 근접 노드 배열 생성
            int start = ints[0];
            int end = ints[1];

            table[start][end] = table[end][start] = true; // 이 부분에서 1을 true로 바꿨는데 메모리 초과가 해결됨
        }
        cnt = bfs(table, visited);
        System.out.println(cnt);

    }

    static int bfs(boolean[][] table, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>(); // bfs 를 위한 큐

        visited[1] = true; // 시작 노드는 1
        queue.offer(1); // 큐에 추가해주기
        int count = 0;

        while (!queue.isEmpty()) { // 큐의 길이가 0일 때 까지
            count = queue.size(); // 큐의 크기

            for (int i = 0; i < count; i++) { // 큐의 길이만큼 돌면서
                int cur = queue.poll(); // 큐의 첫 값을 반환
                for (int j = 0; j < visited.length; j++) { // 노드 길이만큼 돌면서
                    if (!visited[j] && table[cur][j]) { // 방문 여부가 false 이고 근접 노드가 true 일 경우
                        visited[j] = true; // 보고 있는 노드 j를 방문 처리
                        queue.add(j); // j를 큐에 추가
                    }
                }
            }
        }
        return count; // 큐에 남은 크기를 반환
    }
}
