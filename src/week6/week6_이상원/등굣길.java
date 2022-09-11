package week6.week6_이상원;

public class 등굣길 {

    static int m = 4, n = 3;
    static int[][] puddles = {{2, 2}};


    public static void main(String[] args) {
        int[][] d = new int[n + 1][m + 1];

        d[1][1] = 1;
        for (int i = 0; i < puddles.length; i++) {
            int y = puddles[i][1];
            int x = puddles[i][0];
            d[y][x] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (d[i][j] == -1) {
                    d[i][j] = 0;
                    continue;
                }

                if (!(i == 1 && j == 1)) {
                    d[i][j] = (d[i][j - 1] + d[i - 1][j]) % 1000000007;
                }
            }
        }
        System.out.println(d[n][m]);
    }
}
// 블로그 참고 : https://easybrother0103.tistory.com/134