import java.util.Stack;

public class 올바른괄호 {

	boolean solution(String s) {
        Stack<Character> list=new Stack<>();
        
        for(int i=0;i<s.length();i++) {
        	
        	if(s.charAt(i)==')') {
        		if(!list.isEmpty() && list.pop()=='(')
        			continue;
        		else return false;
        	}
        	list.add(s.charAt(i));
        		
        }
        
        if(list.isEmpty())
        	return true;
        
        return false;
        

    }

}
