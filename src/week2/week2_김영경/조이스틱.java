package week2.week2_김영경;

public class 조이스틱 {
	public int solution(String name) {
        int ans = 0;
        int length=name.length();
        int move=length;
        for(int i=0;i<length;i++){
            ans+=Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
            
            int idx=i+1;
            while(idx<length && name.charAt(idx)=='A') idx++;
            
            move=Math.min(move,i*2+(length-idx));
            move=Math.min(move,(length-idx)*2+i);
            
        }
        System.out.println('Z'-name.charAt(0)+1);
        return move+ans;
    }
}
