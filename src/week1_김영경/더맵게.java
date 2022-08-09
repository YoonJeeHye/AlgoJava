import java.util.PriorityQueue;

public class 더맵게 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> list = new PriorityQueue<>();
		int cnt = 0;
		for (int i : scoville)
			list.add(i);

		while (list.peek() < K) {
			if (list.size() == 1)
				return -1;
			int a = list.poll() + list.poll() * 2;
			list.add(a);
			cnt++;
		}

		return cnt;
	}
}