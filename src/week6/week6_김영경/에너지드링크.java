import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class 에너지드링크 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bufferedReader.readLine());
		double[] arr=Arrays.stream(bufferedReader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		
		Arrays.sort(arr);
		
		for(int i=0;i<n-1;i++) {
			arr[n-1]+=(arr[i]/2.0);
		}
		System.out.println(arr[n-1]);
	}

}
