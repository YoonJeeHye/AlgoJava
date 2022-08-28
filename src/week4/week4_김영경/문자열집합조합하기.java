
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class 문자열집합조합하기 {
	
	static int k;
	static HashMap<String, Integer> hashMap=new HashMap<>();
	
	public static void dfs(String rs,int idx,int level,String s) {
		if(level==k) {
			//System.out.println(s);
			if(hashMap.containsKey(s))
				hashMap.replace(s, hashMap.get(s)+1);
			else
				hashMap.put(s, 1);
		}
		else {
			for(int i=idx;i<rs.length();i++) {
				dfs(rs, i+1, level+1, s+rs.charAt(i));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String s1=bufferedReader.readLine();
		String s2=bufferedReader.readLine();
		String s3=bufferedReader.readLine();
		k=Integer.parseInt(bufferedReader.readLine());
		
		dfs(s1,0,0,"");
		dfs(s2,0,0,"");
		dfs(s3,0,0,"");
		
		List<String> keyset=new ArrayList<>(hashMap.keySet());
		
		Collections.sort(keyset);
		
		boolean flag=false;
		
		for(String key:keyset) {
			//System.out.println(hashMap.get(key));
			if(hashMap.get(key)>=2) {
				System.out.println(key);
				flag=true;
			}
		}
		
		if(flag==false)
			System.out.println(-1);
	}

}
