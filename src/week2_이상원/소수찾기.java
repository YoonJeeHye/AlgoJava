package week2_이상원;

import java.util.HashSet;

public class 소수찾기 {static String[] arr;
    static int n, cnt;
    static boolean[] visit;
    static String[] out;
    static HashSet<Integer> hashSet;
    static StringBuilder sb;


    public static void main(String[] args) {
        String numbers = "011";
        arr = numbers.split("");
        n = numbers.length();
        visit = new boolean[n];
        out = new String[n];
        hashSet = new HashSet<>();
        visit = new boolean[n];

        for (int i = 1; i <= n; i++) {
            comb(numbers, visit, 0, i);
        }
        int size = hashSet.size();
        for (int num :
                hashSet) {
            if (isPrime(num) && num != 0) cnt++;
        }
        System.out.println(cnt);
//        return cnt;
    }

    private static void comb(String numbers, boolean[] visit, int depth, int r) {
        if (r == 0) {
            sb = new StringBuilder();
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) sb.append(numbers.charAt(i));
            }
            hashSet.add(Integer.parseInt(String.valueOf(sb)));
            return;
        }
        if (depth == numbers.length()) return;
        else {
            visit[depth] = true;
            comb(numbers, visit, depth + 1, r - 1);

            visit[depth] = false;
            comb(numbers, visit, depth + 1, r);
        }
    }


    private static boolean isPrime(int num) {
        int mid = num / 2;
        for (int i = 2; i <= mid; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
