import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	    public Object[] solution(int[] progresses, int[] speeds) {
	        Queue<Integer> list=new LinkedList<>();
	        Queue<Integer> adds=new LinkedList<>();
	        Queue<Integer> ans=new LinkedList<>();
	        
	        for(int i=0;i<progresses.length;i++) {
	        	list.add(progresses[i]);
	        	adds.add(speeds[i]);
	        	}
	        
	        while(!list.isEmpty()) {
	        int cnt=0;
	        for(int i=0;i<list.size();i++) {
	        	int a=list.poll();
	        	int b=adds.poll();
	        	list.add(a+b);
	        	adds.add(b);
	        }
	        System.out.println(list.toString());
	        while(!list.isEmpty() && list.peek()>=100) {
	        	list.remove();
	        	adds.remove();
	        	cnt++;
	        }
	        if(cnt!=0)
	        	ans.add(cnt);
	        }
	        
	        return ans.toArray();
	        
	    }

}
