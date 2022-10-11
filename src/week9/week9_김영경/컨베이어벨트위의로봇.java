
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

import 등굣길.node;

public class 컨베이어벨트위의로봇 {

	public static void main(String[] args) throws IOException {

		class Node {
			int dur;
			boolean isRobot;

			public Node(int dur, boolean isRobot) {
				super();
				this.dur = dur;
				this.isRobot = isRobot;
			}

			@Override
			public String toString() {
				return "Node [dur=" + dur + ", isRobot=" + isRobot + "]";
			}
		}
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int[] nk = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = nk[0];
		int k = nk[1];
		boolean[] robot = new boolean[2 * n];
		Deque<Node> conq = new ArrayDeque<>();
		Queue<Node> robq = new ArrayDeque<>();
		for (int a : Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
			Node tmp = new Node(a, false);
			conq.addLast(tmp);
		}
		int zeros = 0;
		int cnt = 0;
		while (true) {
			cnt++;
			conq.addFirst(conq.pollLast());
			Node[] nodelist = conq.toArray(new Node[conq.size()]);
			if(nodelist[n-1].isRobot) {
				nodelist[n-1].isRobot=false;
			}
			int size = robq.size();
			for (int j = 0; j < size; j++) {
				Node tmprobot = robq.poll();
				if(!tmprobot.isRobot)continue;
				for (int i = 0; i < n; i++) {
					if (tmprobot == nodelist[i]) {
						if (i == n - 2) {
							if (nodelist[i + 1].dur > 0) {
								nodelist[i + 1].dur--;
								if (nodelist[i + 1].dur == 0) {
									zeros++;
								}
								tmprobot.isRobot = false;
							}
							break;
						} else {
							if (nodelist[i + 1].dur > 0 && !nodelist[i + 1].isRobot) {
								tmprobot.isRobot = false;
								nodelist[i + 1].dur--;
								if (nodelist[i + 1].dur == 0) {
									zeros++;
								}
								nodelist[i + 1].isRobot = true;
								robq.add(nodelist[i + 1]);
							} else
								robq.add(tmprobot); 	
							break;
						}
					}
				}
			}
			// System.out.println(robq);
			if (conq.peekFirst().dur > 0 && !conq.peekFirst().isRobot) {
				// System.out.println("dd");
				conq.peekFirst().dur--;
				if (conq.peekFirst().dur == 0) {
					zeros++;
				}
				conq.peekFirst().isRobot = true;
				robq.add(conq.peekFirst());
			}
			if (zeros >= k)
				break;
		}
		System.out.println(cnt);

	}

}
