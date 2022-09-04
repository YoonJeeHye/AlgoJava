
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 폰호석만 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] st=br.readLine().split(" ");
		int[] st1=new int[st[0].length()];
		int[] st2=new int[st[1].length()];
		int max1=0;
		int max2=0;
		for(int i=0;i<st[0].length();i++) {
			if(st[0].charAt(i)>='a' && st[0].charAt(i)<='z') {
				st1[i]=st[0].charAt(i)-'a'+10;
			}
			else {
				st1[i]=Integer.parseInt(st[0].substring(i, i+1));
			}
			max1=Math.max(max1, st1[i]);
		}
		for(int i=0;i<st[1].length();i++) {
			if(st[1].charAt(i)>='a' && st[1].charAt(i)<='z') {
				st2[i]=st[1].charAt(i)-'a'+10;
			}
			else {
				st2[i]=Integer.parseInt(st[1].substring(i, i+1));
			}
			max2=Math.max(max2, st2[i]);
		}
		max1++;max2++;
		
		long X=-1;
		int a=0;
		int b=0;
		boolean flag=false;
		
		for(int i=max1;i<=36;i++) {
			long num=0;
			for(int x=0;x<st1.length;x++) {
				num+=Math.pow(i, x)*st1[st1.length-1-x];
				if(num>=Long.MAX_VALUE)
					flag=true;
			}
			if(flag) break;
			for(int j=max2;j<=36;j++) {
				long tmpnum=0;
				for(int x=0;x<st2.length;x++) {
					tmpnum+=Math.pow(j, x)*st2[st2.length-1-x];
				}
				if(tmpnum==num) {
					if(X>=0) {
						System.out.println("Multiple");
						return;
					}
					X=num;
					a=i;
					b=j;
					//System.out.println(a+" "+b);
				}
			}
		}
		
		if(X<0 || a==b) {
			System.out.println("Impossible");
			return;
		}
		else
			System.out.println(X+" "+a+" "+b);
		
	}

}
