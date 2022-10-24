package week11.week11_양주연;

import java.io.*;
import java.util.*;

public class 가르침 {
    public static int N, K;
    public static ArrayList<ArrayList<Character>> word = new ArrayList<>();
    public static boolean[] learn = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String line;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (K < 5) {
            System.out.println("0");
            return;
        }
        K -= 5;
        learn['a' - 'a'] = true;
        learn['c' - 'a'] = true;
        learn['n' - 'a'] = true;
        learn['t' - 'a'] = true;
        learn['i' - 'a'] = true;
        for (int x = 0; x < N; x++) {
            line = br.readLine();
            word.add(new ArrayList<>());
            for (int y = 0; y < line.length(); y++) {
                if(!learn[line.charAt(y)-'a'])
                    word.get(x).add(line.charAt(y));
            }
        }
        System.out.println(max_word(0, 0));
    }

    public static int max_word(int idx,int learn_idx) {
        if (K == idx) {
            return readWord();
        }
        if(learn_idx==26)
            return 0;
        int ret = 0;
        if (!learn[learn_idx]) {
            learn[learn_idx] = true;
            ret = Math.max(ret, max_word(idx + 1, learn_idx + 1));
            learn[learn_idx] = false;
        }
        ret = Math.max(ret, max_word(idx, learn_idx + 1));
        return ret;
    }
    
    public static int readWord() {
        boolean flag = true;
        int sum = 0;
        for (int x = 0; x < N; x++) {
            int size = word.get(x).size();
            flag = true;
            for (int y = 0; y < size; y++) {
                if (!learn[word.get(x).get(y) - 'a']) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                sum++;
        }
        return sum;
    }
}