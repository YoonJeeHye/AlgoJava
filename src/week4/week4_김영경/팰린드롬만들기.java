import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬만들기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] alphabet = new int[26];
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		char[] arr = bufferedReader.readLine().toCharArray();

		for (char a : arr)
			alphabet[a - 'A']++;

		int i = 0;
		int tmp = 0;
		int ttmp = 0;
		boolean flag = false;

		for (i = 0; i < 26; i++) {
			int a = alphabet[i];
			if (a % 2 != 0) {
				if (flag == false) {
					for (int q = 0; q < a / 2; q++) {
						stringBuilder.append((char) ('A' + i));
						alphabet[i]--;
					}
					tmp = i;
					ttmp = i;
					flag = true;
				} else {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
			} else if (a > 0) {
				for (int j = 0; j < a / 2; j++) {
					stringBuilder.append((char) ('A' + i));
					alphabet[i]--;
				}
				tmp = i;
			}
		}
		if (flag == true) {
			stringBuilder.append((char) ('A' + ttmp));
			alphabet[ttmp]--;
		}
		for (; tmp >= 0; tmp--) {
			int a = alphabet[tmp];
			for (int j = 0; j < a; j++)
				stringBuilder.append((char) ('A' + tmp));
		}

		System.out.println(stringBuilder);

	}

}
