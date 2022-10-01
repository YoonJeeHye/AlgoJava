package week8.week8_양주연;

import java.io.*;

public class 순열의순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		//1<=N<=20이므로 순열 사용하면 시간초과.
		long[] fact = new long[N+1]; //팩토리얼 값 저장할 배열
		fact[0] = fact[1] = 1;
		for(int i=2; i<=N; i++){
		    fact[i] = fact[i-1]*i; 
		}
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N]; //순열 저장할 배열
		boolean[] isSelected = new boolean[N+1]; //해당 숫자 선택되었는지 여부
		if(input[0].equals("1")){ //소문제 번호가 1인 경우
		    long k = Long.parseLong(input[1]);
		    for(int i=0; i<N; i++){
		        for(int j=1; j<=N; j++){
		            if(isSelected[j]) continue;
		            if(k<=fact[N-1-i]){
		                isSelected[j] = true;
		                arr[i] = j;
		                break;
		            }else{
		                k-=fact[N-1-i]; 
		            }
		        }
		    }
		    for(int i=0; i<N; i++) bw.write(arr[i]+" ");
		}else{ //소문제 번호가 2인 경우
		    for(int i=0; i<N; i++){
		        arr[i] = Integer.parseInt(input[i+1]);
		    }
		    long cnt=1; //순열 1번째부터 시작
		    for(int i=0; i<N; i++){
		        for(int j=1; j<arr[i]; j++){
		            if(!isSelected[j]) cnt+=fact[N-1-i];
		        }
		        isSelected[arr[i]] = true;
		    }
		    bw.write(cnt+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}


// 소문제 번호가 1일 경우, (k번째 순열을 구하는 경우)
// 1~N까지를 순열로 나열하고 있고, 현재 x번째 자리수에 들어갈 수를 선택하고 있다고 하면,
// 1) k<=(N-x)!이면 현재 수 선택하여 현재 자리수에 저장하고 다음 자리수로 넘어감.
// 2) k>(N-x)!이면 다음 자리수로 넘어가지 않고 현재 자리수에서 다음 선택 가능한 수로 넘어가고, k에서 fact[N-1-i]를 빼줌.
// ex. N=4이고 k=3일 경우, (순열 : _ _ _ _ )
// (k=3) <= 3! 이므로 첫번째 자리수에 1을 저장하고 다음인 두번째 자리수로 넘어간다. 
// (k=3) > 2! 이므로 2에서 다음 선택 가능한 수인 3으로 넘어가고, k에서 2! 빼주면 k는 1이 됨. 
// (k=1) <= 2! 이므로 두번째 자리수에 3을 저장하고 다음인 세번째 자리수로 넘어감.
// (k=1) <= 1! 이므로 세번째 자리수에 2를 저장하고 다음인 네번째 자리수로 넘어감.
// (k=1) <= 0! 이므로 네번째 자리수에 4를 저장하고 끝.
// 따라서 3번째 순열은 1 3 2 4.

// 소문제 번호가 2일 경우, (이 순열이 몇 번째 순열인지를 구하는 경우)
// 1~N까지를 순열로 나열하고 있고, 현재 x번째 자리수에 들어갈 수를 선택하고 있다고 하면,
// 몇번째 순열인지를 저장할 cnt 변수를 1로 초기화하고
// (N-x)!를 해당 자리수에 지금 숫자가 오기 이전까지 올 수 있었던 숫자 개수만큼 반복하여 cnt에 더함.
// ex. N=4이고 1 3 2 4 가 몇 번째 순열인지를 구하는 경우,
// 첫번째 자리수에 1이 오기 이전까지 올 수 있었던 숫자는 없으므로 cnt에 3!을 더하는 일 없이 두번째 자리수로 넘어감.
// 두번째 자리수에 3이 오기 이전까지 올 수 있었던 숫자는 2가 있으므로 cnt에 2!을 한 번 더해주면 cnt는 3이됨. 
// 세번째 자리수에 2가 오기 이전까지 올 수 있었던 숫자는 없으므로 그냥 다음 자리수로 넘어감.
// 네번째 자리수에 4가 오기 이전까지 올 수 있었던 숫자는 없으므로 끝.
// 따라서 1 3 2 4는 3번째 순열.