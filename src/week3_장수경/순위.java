class Solution {
	public int solution (int n, int[][] results){
	    boolean[][] linked =  new boolean[n][n];
	    int answer = 0;
	    for(int i=0; i<results.length; i++){ 
	    	linked[results[i][0]-1][results[i][1]-1]=true; }

	    //플로이드 워셜 알고리즘
	    for(int i=0; i<n; i++){
	        for(int j=0; j<n; j++){
	            for(int k=0; k<n; k++){
	                if(linked[j][i]&&linked[i][k]){linked[j][k]=true;}
	            }
	        }
	    }
	    
	    //결과 갯수 세기
	    for(int i=0; i<n; i++){
	        int result=0;
	        for(int j=0; j<n; j++){
	            if(linked[i][j] || linked[j][i]){result++;}
	        }
	        if(result==n-1){answer++;}
	    }
	    return answer;
	    
	}   
}
