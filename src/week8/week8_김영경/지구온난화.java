import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 지구온난화 {
	
	
	
	public static void main(String[] args) throws IOException  {
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		int[] rc=Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int r=rc[0];
		int c=rc[1];
		String[][] map=new String[r][];	//원본 맵
		String[][] tmpmap=new String[r][c];	//수정을 적용한 맵
		for(int i=0;i<r;i++) {
			map[i]=bufferedReader.readLine().split("");
			for(int j=0;j<c;j++) {
				tmpmap[i][j]=map[i][j];
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {	//모든 원소의 대하여
				if(".".equals(map[i][j]))continue;	//바다면 건너뛴다.
				int cnt=0;
				if(i-1<0 || ".".equals(map[i-1][j]))cnt++;
				if(i+1>=r || ".".equals(map[i+1][j]))cnt++;
				if(j-1<0 || ".".equals(map[i][j-1]))cnt++;
				if(j+1>=c || ".".equals(map[i][j+1]))cnt++;
				if(cnt>=3) {
					tmpmap[i][j]=".";	//4면중 3면 이상이 바다면 바다로 변경
				}
			}
		}
		int minr=11;
		int minc=11;
		int maxr=-1;
		int maxc=-1;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {	//섬인곳중 X,Y좌표가 가장 작은값과 큰값을 구한다.
				if("X".equals(tmpmap[i][j])) {
					minr=Math.min(i, minr);
					minc=Math.min(j, minc);
					maxr=Math.max(i, maxr);
					maxc=Math.max(j, maxc);
				}
			}
		}
		//System.out.println(Arrays.deepToString(tmpmap));
		for(int i=minr;i<=maxr;i++) {	//구한 X,Y좌표만큼의 원소를 출력
			for(int j=minc;j<=maxc;j++) {
				System.out.print(tmpmap[i][j]);
			}
			System.out.println();
		}
	}

}
