package week5.week5_양주연;

import java.io.*;
public class 폰호석만
{
    static int getX(String s, int radix){
        int res=-1;
        try{
            res = Integer.parseInt(s, radix);
        }catch(NumberFormatException e){
            return res;
        }
        finally{
            return res;
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    String[] input = br.readLine().split(" ");
	    int cnt=0;
	    int X=0, A=0, B=0;
	    for(int i=2; i<=36; i++){
	        for(int j=2; j<=36; j++){
	            if(i==j) continue;
	            int tmp1 = getX(input[0], i);
	            int tmp2 = getX(input[1], j);
	            if(tmp1!=-1 && tmp1==tmp2){
	                if(A==0){
	                    X = tmp1;
	                    A = i;
	                    B = j;
	                }
	                cnt++;
	            }
	        }
	    }
	    if(cnt==0) bw.write("Impossible");
	    else if(cnt>1) bw.write("Multiple");
	    else bw.write(X+" "+A+" "+B);
	    br.close();
	    bw.flush();
	    bw.close();
	}
}