package week2_이상원;

import java.util.Arrays;

public class 섬연결하기 {
    static int n, cnt, cost;
    static int[] cycle;

    public static void main(String[] args) {
        n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        cnt = 0;
        // 사이클 테이블 선언
        cycle = new int[n];
        for (int i = 0; i < n; i++) {
            cycle[i] = i;
        }
        int[][] newCost = new int[n][];
        for (int i = 0; i < n; i++) {
            if (costs[i].length == 3) {
                newCost[i] = new int[]{costs[i][0], costs[i][1], costs[i][2]};
            } else {
                newCost[i] = new int[]{costs[i][0], costs[i][1], Integer.MAX_VALUE};
            }
        }

        // 비용 순으로 정렬
        Arrays.sort(newCost, ((o1, o2) -> o1[2] - o2[2]));

        for (int i = 0; i < newCost.length; i++) {
            int[] item = newCost[i];

            // 사이클 테이블 갱신
            int start = item[0]; // source
            int end = item[1]; // dest
            cost = item[2];
            if (cost != Integer.MAX_VALUE) {
                int starParent = find(start);
                int endParent = find(end);
                if (starParent == endParent) continue;

                cnt += cost;
                cycle[end] = starParent;
            } // cost
            else continue;
        }
        System.out.println(cnt);
//        return cnt;
    }

    private static int find(int node) {
        if (cycle[node] == node) return node;
        return cycle[node] = find(cycle[node]);
    }
}
