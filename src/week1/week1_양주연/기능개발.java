package week1.week1_양주연;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length]; // 몇일간 작업 후 배포 가능한지 일수 저장해둔 배열 days
        //{5, 10, 1, 1, 20, 1} 일 경우 5, 10, 20 일째에 기능이 배포됨.
        int max=0, cnt=0; //일수 max가 갱신될 때마다 다음 배포 구간이 시작되므로 max 0으로 초기화, 총 배포 몇번인지 cnt 변수에 저장
        for(int i=0; i<progresses.length; i++){
            if((100-progresses[i])%speeds[i]==0) //딱 맞게 나뉘면 일수 그냥 저장
                days[i] = (100-progresses[i])/speeds[i];
            else days[i] = (100-progresses[i])/speeds[i]+1; //나머지 있으면 일수+1 저장
            if(days[i]>max){ 
                max = days[i];
                cnt++; //일수 max가 몇번 갱신되는지 cnt변수에 저장
            }
        }
        int[] answer = new int[cnt]; //각 배포마다 몇 개의 기능 배포되는지 담을 answer 배열 생성
        max=0; //max 다시 0으로 초기화
        int idx=-1;
        for(int x : days){
            if(x>max){
                max=x;
                answer[++idx]=1; //max 갱신되므로 일수 추가
            }
            else answer[idx]++; //갱신된 max일수 때 같이 배포되므로 추가해 둔 일 수에 +1
        }
        return answer;
    }
}