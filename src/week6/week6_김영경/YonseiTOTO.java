import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class YonseiTOTO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = arr[0];
		int mil = arr[1];
		ArrayList<Integer> usemil = new ArrayList<>();

		for (int q = 0; q < n; q++) {
			int[] pl = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int l = pl[1];
			
			int[] list2 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Integer[] list=Arrays.stream(list2).boxed().toArray(Integer[]::new);
			
			Arrays.sort(list,Comparator.reverseOrder());
			
			if (l > pl[0])
				usemil.add(1);
			else
				usemil.add(list[l - 1]);
		}

		Collections.sort(usemil);
		

		int sum = 0;
		int cnt = 0;
		for (int i : usemil) {
			if (sum + i <= mil) {
				sum += i;
				cnt++;
			} else {
				break;
			}
		}
		System.out.println(cnt);
	}

}
