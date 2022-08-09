import java.awt.List;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class 같은숫자는싫어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Object[] solution(int[] arr) {
		Stack<Integer> list=new Stack<>();
		
		for(int i:arr){
			if(list.size()!=0 && list.peek()==i)
				continue;
			else
				list.add(i);
		}
		
		return list.toArray();
		
		
	}

}
