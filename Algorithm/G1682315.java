package Algorithm;

import java.util.*;

public class G1682315 {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] metabus = new int[1002][1002];
		for(int i=0;i<metabus.length;i++){
			Arrays.fill(metabus[i],0);
		}
		
		for(int i=0;i<n;i++){
			int lux = sc.nextInt();
			int luy = sc.nextInt();
			int rdx = sc.nextInt();
			int rdy = sc.nextInt();
			
			metabus[lux+1][luy+1]++;
			metabus[rdx+1][rdy+1]++;
			metabus[lux+1][rdy+1]--;
			metabus[rdx+1][luy+1]--;	
		}
		
		for(int i=0;i<1002;i++){
			for(int j=1;j<1002;j++){
				metabus[i][j]+=metabus[i][j-1];
			}
		}
		
		for(int j=0;j<1002;j++){
			for(int i=1;i<1002;i++){
				metabus[i][j]+=metabus[i-1][j];
			}
		}
		
		int result=0;
		for(int j=0;j<1002;j++){
			for(int i=0;i<1002;i++){
				if(metabus[i][j]==k){
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
