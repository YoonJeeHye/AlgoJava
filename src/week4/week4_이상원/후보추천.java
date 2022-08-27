package week4.week4_이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 후보추천 {
    static int N, recommend;
    static int[] student;

    static class Student implements Comparable<Student> {
        int no, create, vote;

        public Student(int no, int create, int vote) {
            this.no = no;
            this.create = create;
            this.vote = vote;
        }

        @Override
        public int compareTo(Student o) {
            if (this.vote != o.vote) {
                return this.create - o.create;
            }
            return this.vote - o.vote;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        recommend = Integer.parseInt(br.readLine());

        // 학생 번호, 생성 시점, 투표 수
        List<Student> queue = new ArrayList<>();
        int[] vote = new int[101];
        student = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < student.length; i++) {
            // 투표를 돌면서
            if (queue.size() < N) {
                // 학생 추가 가능
                if (vote[student[i]] == 0) {
                    // 게시가 안됐으면
                    vote[student[i]] += 1;
                    queue.add(new Student(student[i], i, vote[student[i]]));
                } else {
                    // 이미 게시 된 거면
                    vote[student[i]] += 1; // 투표 수 추가만
                }
            } else {
                // 틀이 다 찼으면
                if (vote[student[i]] == 0) {
                    Collections.sort(queue);
                    int curNo = queue.get(0).no;
                    vote[curNo] = 0;
                    queue.remove(0); // 빼고
                    vote[student[i]] += 1;
                    queue.add(new Student(student[i], i, vote[student[i]]));
                } else {
                    vote[student[i]] += 1;
                }
            }
        }
        int[] answer = new int[101];
        for (int i = 0; i < queue.size(); i++) {
            answer[i] = queue.get(i).no;
        }
        Arrays.sort(answer);
        for (int i = 0; i < N; i++) {
            if (answer[i] != 0)
                System.out.print(answer[i] + " ");
        }

    }
}
