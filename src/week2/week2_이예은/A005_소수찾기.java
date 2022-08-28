package week2.week2_이예은;

public class A005_소수찾기 {
    int answer = 0;
    boolean[] checked = new boolean[10000000]; // 같은 숫자인지 체크한다 9999999이 최대 값
    boolean[] visited;// 종이 조각을 사용했는지 체크한다
    int N;
    
    public boolean isPrime(int n) // geeksforgeeks
    {   
        if (n <= 1)// 0, 1 은 소수가 아니다
            return false;
        if (n <= 3)// 2, 3 은 소수
            return true;
        if (n % 2 == 0 || n % 3 == 0) // 2나 3으로 나눠지는 지 확인
            return false;
        for (int i = 5; i * i <= n; i = i + 6) // 나눠지는 수가 있다면 소수가 아니다
            if (n % i == 0 || n % (i + 2) == 0) 
                // 2와 3은 다 체크 했기 때문에 6씩 늘어나면서 i와 i+2를 체크한다
                return false;
        return true; 
    }
    
    public void permutation(String numbers, int path, int cnt){
        if (cnt == N)
            return;
        
        for(int i = 0; i < N; i++){
        	if(visited[i]) continue; // 예전에 사용한 적이 있는 종이 조각이면 넘어간다
        	
        	path = path * 10 + (numbers.charAt(i)-'0');
        	
            if(isPrime(path) && !checked[path]) { // 소수인지 이전에 있던 숫자인지 확인한다
            	checked[path] = true;
            	answer++; 
            }
     
            visited[i] = true;
            permutation(numbers, path, cnt+1);
            visited[i] = false;
            
            path = path / 10;  
        }  
    }
    
    public int solution(String numbers) {
        N = numbers.length();
    	visited = new boolean[N];

        permutation(numbers, 0, 0);
        return answer;
    }
}

