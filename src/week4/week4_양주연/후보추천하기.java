package week4.week4_양주연;

import java.io.*;
import java.util.*;

public class 후보추천하기
{
    static class Student implements Comparable<Student>{
        int num; //학생 번호
        int voteCnt; //추천받은 횟수
        int time; //게시된 시간
        public Student(int num, int voteCnt, int time){
            this.num=num;
            this.voteCnt=voteCnt;
            this.time=time;
        }
        public int compareTo(Student o){
            if(this.voteCnt==o.voteCnt) return this.time-o.time; //추천받은 횟수가 같을 경우 게시된 시간순 오름차순 정렬(게시된 지 가장 오래된 사진이 먼저 나오게)
            else return this.voteCnt-o.voteCnt; //추천 받은 횟수 기준 오름차순 정렬
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); //사진틀 개수
		int M = Integer.parseInt(br.readLine()); //총 추천횟수
		PriorityQueue<Student> pq = new PriorityQueue<>(); //PriorityQueue 생성. 사진이 게시된 학생들이 삽입되는 큐.
		String[] input = br.readLine().split(" "); 
		for(int i=0; i<M; i++){ //전체 학생의 총 추천 회수만큼 반복
		    int num = Integer.parseInt(input[i]); //추천받은 학생의 번호
		    boolean isFound = false; //이미 사진이 게시된 학생이었는지 체크용 변수
		    for(Student s : pq){
		        if(s.num==num){ //추천받은 학생이 이미 사진이 게시된 학생이었을 경우
		            //우선순위 큐에 삽입할 때 정렬이 되기 때문에
		            //for each문으로 순회하면서 s.voteCnt++로 수정해 봤자 
		            //처음 큐에 삽입할 때 정해진 데이터 기준의 우선순위로 큐에 저장되어 있어 오답나옴.
		            //따라서 수정해서 삽입하고 예전 것 큐에서 뺌.
		            pq.offer(new Student(s.num, s.voteCnt+1, s.time)); //추천받은 횟수만 1 증가시켜 삽입
		            pq.remove(s); //예전 것 우선순위 큐에서 삭제
		            isFound = true; //isFound값 true로 변경
		            break; //반복문에서 빠져나옴
		        }
		    }
		    if(!isFound){ //추천받은 학생이 이미 사진이 게시된 학생이 아니었을 경우
		        if(pq.size()==N) pq.poll(); //비어있는 사진틀이 없을 경우 우선순위 큐에서 하나 꺼냄.
		        pq.offer(new Student(num, 1, i)); //우선순위 큐에 학생 삽입(=사진틀에 해당 학생 게시)
		    }
		}
		ArrayList<Integer> answer = new ArrayList<>(); //사진틀에 사진이 게재된 최종 후보들 담을 ArrayList 생성
		for(Student s : pq){
		    answer.add(s.num); //학생 번호만 저장
		}
		Collections.sort(answer); //학생 번호 기준 오름차순 정렬
		for(int x : answer){
		    bw.write(x+" "); //정답 출력
		}
		br.close();
		bw.flush();
		bw.close();
	}
}