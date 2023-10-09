package Algorithm;

import java.util.*;
import java.io.*;

public class B5014 {
    static public void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[f+1];
		Arrays.fill(cnt,  -1);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		cnt[s]=0;
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x+u<=f) {
				if(cnt[x+u]==-1 || cnt[x+u]>cnt[x]+1) {
					cnt[x+u]=cnt[x]+1;
					q.add(x+u);
				}
			}
			if(x-d>=1) {
				if(cnt[x-d]==-1 || cnt[x-d]>cnt[x]+1) {
					cnt[x-d]=cnt[x]+1;
					q.add(x-d);
				}
			}
			
		}
		
		if(cnt[g]==-1) {
			System.out.println("use the stairs");
		}
		else {
			System.out.println(cnt[g]);
		}
	}
}
