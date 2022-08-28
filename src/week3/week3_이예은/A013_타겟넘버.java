package week3.week3_이예은;

class A013_타겟넘버 {
    int count;
    public void DFS(int index, int sum, int[] numbers, int target) {
        if(index == numbers.length){ // numbers의 끝까지 왔을 때 target 숫자랑 같은지 비교한다
            count += (sum == target)? 1: 0;
            return;
        }
        DFS(index+1, sum + numbers[index], numbers, target); // + -> DFS재귀 호출
        DFS(index+1, sum - numbers[index], numbers, target); // - -> DFS재귀 호출  
    }
    public int solution(int[] numbers, int target) {
		count = 0;
		DFS(0, 0, numbers, target);
        return count;
    }
}
