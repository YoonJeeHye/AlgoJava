package week3.week3_윤지혜;

public class 가장먼노드 {

	public static void main(String[] args) {
		int[][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		solution(6,vertex);
	}

	public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        int arr[][] = new int[n+1][n+1];	// 인접행렬
        for(int i = 0; i < edge.length; i++) {
        	arr[edge[i][0]][edge[i][1]] = arr[edge[i][1]][edge[i][0]] = 1;
        }
        
        
        
        return answer;
    }
}
