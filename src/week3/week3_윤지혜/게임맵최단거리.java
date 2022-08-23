package week3.week3_윤지혜;

public class 게임맵최단거리 {

	static int answer = Integer.MAX_VALUE;
	static int sum;
	// 하 오 상 좌
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,1,0,-1};
	
	static boolean visited[][];
	
	public static void main(String[] args) {
		int[][] maps = { {1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
		System.out.println(solution(maps));
	}

	public static int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        dfs(0,0, maps, 1);
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

	private static void dfs(int r, int c, int[][] maps, int sum) {
		
		if(r == maps.length-1 && c == maps[0].length-1) { 
			answer = answer > sum ? sum : answer;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int R = r + dr[i];
			int C = c + dc[i];
			
			// 가려는 방향이 범위 밖이거나 벽이거나 이미 왔던 길이면 패스
			if(R<0 || R>=maps.length || C<0 || C>=maps[0].length || maps[R][C] == 0 || visited[R][C]) continue;
			
			// 갈 수 있는 길이면
			visited[R][C] = true;
			dfs(R,C,maps,sum+1);
		}
		
	}
}
