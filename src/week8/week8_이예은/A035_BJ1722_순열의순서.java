package week8.week8_이예은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class A035_BJ1722_순열의순서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();\
		
		
		// next permutation도 시간초과..
		// 결국 각 자리에 올수 있는 경우의 수와 남아있는 수중에서 얼마나 작은 수인지를 구해서 순열을 만들어줘야한다
		// 주의 경우의 수가 최대 20!가 될수 있기때문에 int형으로는 담지 못하고  long을 사용해야한다!
		int N = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int k = Integer.parseInt(inputs[0]);
		int[] data = new int[N];
		boolean[] visited = new boolean[N + 1];
		
		long factori = 1;// 경우의 수를 구한다
		// 초기 값 = 순열 첫번째에 임의의 숫자 n이 올 경우의 수
		for (int i = 1; i < N; i++) {
			factori *= i;
		}
		int len = 0; // 순열의 길이

		if (k == 1) {
			long n = Long.parseLong(inputs[1]) - 1; // n번째로 큰 순열을 구한다

			while (len < N) {
				long m = n / factori; // 몫에 따라 숫자가 정해진다
				int cnt = 0;
				for (int i = 1; i <= N; i++) { // 방문하지 않은 숫자중에서 m번째 숫자를 찾는다
					if (visited[i])
						continue;
					if (cnt == m) { // m 번째 숫자를 찾았을때
						visited[i] = true;// 방문처리를 하고
						sb.append(i).append(" ");// String Buffer에 넣어준다
						break;
					}
					cnt++;
				}
				
				if (len == N-1) break; // 마지막은 0으로 factori를 나눌 수가 없어서 오류를 막기 위해 바로 빠져나간다
				// 값 갱신하기
				n = n % factori;
				factori /= (N-1) - len; // 순열 len번째에 임의의 숫자 b가 올 경우의 수
				len++;
			}
		} else {
			long result = 0;

			for (int i = 1; i <= N; i++) {
				int n = Integer.parseInt(inputs[i]); // 순열의 각자리의 숫자를 가져온다

				int cnt = 0;// 아직 방문하지 않은 숫자중에 몇변째로 작은 숫자인지 구한다
				for (int j = 1; j <= N; j++) {
					if (visited[j]) continue;
					if (n == j) {
						visited[j] = true;
						break;
					}
					cnt++;
				}
				result += factori * cnt; // 몇번째로 작은지 * len번째 자리에 임의의 숫자 a가 올 경우의 수
				if (len == N-1) break;
				factori /= (N-1) - len; // 순열 len번째에 임의의 숫자 b가 올 경우의 수
				len++;
			}
			sb.append(result + 1);

		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();

	}
}

