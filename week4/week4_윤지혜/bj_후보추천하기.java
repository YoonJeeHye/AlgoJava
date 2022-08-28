package week4_윤지혜;

import java.util.*;

public class bj_후보추천하기{

	static int N;
	static ArrayList<Integer> photoFrame;
	static boolean visited[];
	static int chk_reco_cnt[];
	static int pF_cnt;	// 사진틀에 몇 개의 사진 들어가있는지 count
	
	static int temp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 사진틀 개수
		photoFrame = new ArrayList<>();	// 사진틀 개수만큼의 (추천받은 학생 넣을)배열
		int total_reco = sc.nextInt();	// 학생들의 총 추천 횟수
		
		chk_reco_cnt = new int[101];	// 학생은 1~100까지 있을 수 있음 (각 학생 별 추천 횟수 체크)
		visited = new boolean[101];	// photoFrame 배열에 중복되어 들어가지 않도록 체크하는 배열
		for(int TR = 0; TR < total_reco; TR++) {
			int stu_num = sc.nextInt();	// 추천받는 학생 번호
			chk_reco_cnt[stu_num]++;	// stu_num번 학생
			
			// 비어있을 경우 (+ 이미 들어간 애가 또 들어가지 않는지 중복 체크 해줘야 함)
			if(pF_cnt < N) {
				// 사진틀에 들어가지 않은 애면
				if(visited[stu_num]==false) {
					photoFrame.add(stu_num);	// 사진 틀에 넣어주고
					pF_cnt++;	// 사진 틀에 들어간 개수++
					visited[stu_num] = true;	// photoFrame 배열에 들어갔다고 체크
				}
			}
			
			// 꽉 차 있는 경우 (= N번까지 다 받은 경우)
			// 추천받은 횟수가 가장 적은 학생 삭제 -> 가장 추천 횟수 적은 학생 찾기
			else {
				if(visited[stu_num]==false) {
					int min = Integer.MAX_VALUE;
					for(int i = 0; i < photoFrame.size(); i++) {
						if(chk_reco_cnt[photoFrame.get(i)] < min) {
							min = chk_reco_cnt[photoFrame.get(i)];
							temp = i;
						}
					}
	
						chk_reco_cnt[photoFrame.get(temp)] = 0;	// 삭제될 학생의 추천 횟수는 0
						visited[photoFrame.get(temp)] = false;	// 사진 틀에 들어가지 않음 체크
						photoFrame.remove(temp);	// 삭제될 학생 사진틀에서 삭제
						
						
						photoFrame.add(stu_num);	// 새로 추천받은 학생 집어넣기
						visited[stu_num] = true;	// 사진 틀에 들어감 체크
		
				}
				
			}
		
		}
		// 최종 후보 소팅
		Collections.sort(photoFrame);
		// 최종 후보 출력
		for(int i : photoFrame) {
			System.out.print(i+" ");
		}
				
	}
}
