package Algorithm;

import java.util.*;
import java.io.*;

public class swea1974 {
	static int t;
	static int[][] matrix;
	static int answer;
	static int[][] start = {{0,0}, {0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
	static int[] dx = {0,0,0,1,1,1,2,2,2};
	static int[] dy = {0,1,2,0,1,2,0,1,2};

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		t = Integer.parseInt(st.nextToken());
		
		for(int testcase=1;testcase<=t;testcase++) {
			System.out.print("#"+testcase+ " ");
			input(br, st);
			answer = solution();
			System.out.println(answer);
		}
	}
	
	static int solution() {
		boolean[] visited = new boolean[10];
		
		for(int i=0;i<9;i++) {
			Arrays.fill(visited, false);
			for(int j=0;j<9;j++) {
				if(visited[matrix[i][j]]==true) {
					return 0;
				}else {
					visited[matrix[i][j]]=true;
				}
			}
		}
		
		for(int i=0;i<9;i++) {
			Arrays.fill(visited, false);
			for(int j=0;j<9;j++) {
				if(visited[matrix[j][i]]==true) {
					return 0;
				}else {
					visited[matrix[j][i]]=true;
				}
			}
		}
		
		for(int i=0;i<9;i++) {
			Arrays.fill(visited, false);
			int x = start[i][0];
			int y = start[i][1];
			for(int j=0;j<9;j++) {
				int nx = x+dx[j];
				int ny = y+dy[j];
				if(visited[matrix[nx][ny]]==true) {
					return 0;
				}else {
					visited[matrix[nx][ny]]=true;
				}
			}
		}
		return 1;
		
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
		matrix = new int[9][9];
		answer = -1;
		
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<9;j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
	}

}

