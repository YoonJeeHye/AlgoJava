import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class 소수찾기 {

	static char[] tmp;

	static boolean[] visited;


	static ArrayList<Integer> done = new ArrayList<>();
	static ArrayList<Integer> ans = new ArrayList<>();

	static boolean sosu(int a) {
		if (a <=1)
			return false;
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

	static void dfs(String sublist) {
		if (!sublist.equals("") && !done.contains(Integer.parseInt(sublist))) {
			if (sosu(Integer.parseInt(sublist)))
				ans.add(Integer.parseInt(sublist));
			done.add(Integer.parseInt(sublist));
		}

		for (int i = 0; i < tmp.length; i++) {
			if (visited[i] == true)
				continue;
			visited[i] = true;
			sublist += tmp[i];
			dfs(sublist);
			visited[i] = false;
			sublist = sublist.substring(0, sublist.length() - 1);
		}
	}

	public static int solution(String numbers) {
		tmp = numbers.toCharArray();
		visited = new boolean[tmp.length];
		dfs("");
		return ans.size();
	}

	public static void main(String[] args) {
		System.out.println(solution("1231"));
		Collections.sort(ans);
		System.out.println(ans.toString());
	}

}
