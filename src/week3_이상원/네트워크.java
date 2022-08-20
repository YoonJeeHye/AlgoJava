package week3_이상원;

public class 네트워크 {
    static int n, cnt; // n: 점의 개수 cnt: 네트워크 개수
    static boolean[] visit; // 방문 여부 확인 배열
    static boolean check;

    public static void main(String[] args) {
        n = 3;
//        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        cnt = 0;
        visit = new boolean[n]; // 방문 여부 저장
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                cnt += 1;
                dfs(computers, i); // 1이 아니면 탐색

            }
        }
        System.out.println(cnt);
    }

    private static boolean dfs(int[][] computer, int idx) {
        visit[idx] = true;
        for (int i = 0; i < computer.length; i++) {
            if (i != idx && computer[idx][i] == 1 && !visit[i])
                check = dfs(computer, i);
        }
        return check;
    }
}
