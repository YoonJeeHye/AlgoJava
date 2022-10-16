package week10.week10_이예은;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class A041_BJ1966_프린터큐 {
    static class Document {
        int idx, imp;

        public Document(int idx, int imp) {
            this.idx = idx;
            this.imp = imp;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int M = Integer.parseInt(inputs[1]);
            ArrayList<Integer> arr = new ArrayList<>();
            Queue<Document> queue = new ArrayDeque<>();

            inputs = br.readLine().split(" ");
            for(int i = 0; i < N; i++){
                int v = Integer.parseInt(inputs[i]);
                arr.add(v);
                queue.add(new Document(i, v));
            }
            Collections.sort(arr, Collections.reverseOrder());

            int i = 0;
            int cnt = 1;
            while(!queue.isEmpty()){
                Document d = queue.poll();

                if(d.imp == arr.get(i)) { // 프린트 할수 있을때
                    if(d.idx == M) break;
                    ++i;
                    ++cnt;
                } else { // 프린트 할 수 없을때
                    queue.add(d);
                }
            }
            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }
}