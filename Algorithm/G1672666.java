package Algorithm;

import java.io.*;
import java.util.*;

public class G1672666 {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] island = new int[n+1][n+1];
		for(int i=0;i<m;i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			island[start][end]=1;
			island[end][start]=1;
		}
		
		// BFS
		boolean[] visited = new boolean[n+1];
		int[] depth = new int[n+1];
		Arrays.fill(depth, -1);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1]=true;
		depth[1]=0;
		while(!queue.isEmpty()){
			int now = queue.poll();
			for(int i=1;i<=n;i++){
				if(island[now][i]==1 && visited[i]==false){
					queue.add(i);
					visited[i]=true;
					depth[i] = depth[now]+1;
				}
			}
		}
		
		String result = depth[n]!=-1 && depth[n]<=k ? "YES" : "NO" ;
		System.out.println(result);
	}
}
