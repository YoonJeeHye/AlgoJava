import java.awt.Checkbox;
import java.awt.List;
import java.awt.geom.FlatteningPathIterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 빙고 {

	static ArrayList<Integer> arrayList = new ArrayList<>();
	static int[] a = { 0, 6, 12, 18, 24 };
	static int[] b = { 4, 8, 12, 16, 20 };

	public static boolean check(int tmp) {
		int cnt = 0;
		int index = arrayList.indexOf((Object) tmp);
		arrayList.set(index, -1);
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			if (arrayList.get(a[i]) > 0) {
				flag = true;
				break;
			}
		}
		if (!flag)
			cnt++;
		flag = false;
		for (int i = 0; i < 5; i++) {
			if (arrayList.get(b[i]) > 0) {
				flag = true;
				break;
			}
		}
		if (!flag)
			cnt++;
		for (int q = 0; q < 25; q += 5) {
			flag = false;
			for (int i = 0; i < 5; i++) {
				if (arrayList.get((q / 5) * 5 + i) > 0) {
					flag = true;
					break;
				}
			}
			if (!flag)
				cnt++;
		}
		for (int q = 0; q < 5; q++) {
			flag = false;
			for (int i = 0; i < 5; i++) {
				if (arrayList.get((q % 5) + (i * 5)) > 0) {
					flag = true;
					break;
				}
			}
			if (!flag)
				cnt++;
		}
		// System.out.println(arrayList);
		// System.out.println(cnt);
		if (cnt >= 3)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < 5; j++) {
				arrayList.add(tmp[j]);
			}
		}
		// System.out.println(arrayList);
		for (int i = 0; i < 5; i++) {
			int[] tmp = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < 5; j++) {
				cnt++;
				if (check(tmp[j])) {
					System.out.println(cnt);
					return;
				}
			}
		}
	}

}
