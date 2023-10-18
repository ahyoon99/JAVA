package Algorithm;

import java.util.*;
import java.io.*;

public class swea1949 {
    static int n;
	static int k;
	static int[][] map;
	static int maxLength;
	static ArrayList<Node> top;

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("res/input_swea1949.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			solution(br, st);
			System.out.println("#"+test_case+" "+maxLength);
			/////////////////////////////////////////////////////////////////////////////////////////////
			
			
		}
	}
	
	static public void solution(BufferedReader br, StringTokenizer st) throws IOException {
		
		input(br, st);
		
		for(Node node : top) {
			maxLength = Math.max(maxLength,dfs(node.x, node.y));
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int med = map[i][j];
					for(int l=0;l<k;l++) {
						map[i][j]--;
						maxLength = Math.max(maxLength,dfs(node.x, node.y));
						
					}
					map[i][j]=med;
				}
			}
			
		}
		
		
	}
	
	static public void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		int maxVal = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>maxVal) {
					maxVal = map[i][j];
				}
			}
		}
		
		top = new ArrayList<Node>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==maxVal) {
					top.add(new Node(i,j));
				}
			}
		}
		maxLength=Integer.MIN_VALUE;
	}
	
	static public int dfs(int x, int y) {
		Stack<Node> st = new Stack<>();
		int[][] distance = new int[n][n];
		
		st.push(new Node(x,y));
		distance[x][y]=1;
		boolean flag;
		
		while(!st.isEmpty()) {
			Node node = st.peek();
			x = node.x;
			y = node.y;
			flag = false;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					if(map[x][y]>map[nx][ny] && distance[nx][ny]<distance[x][y]+1) {
						st.push(new Node(nx, ny));
						distance[nx][ny]=distance[x][y]+1;
						flag=true;
						break;
					}
				}
			}
			if(!flag) {
				st.pop();
			}
		}
		
		int maxVal = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(maxVal<distance[i][j]) {
					maxVal = distance[i][j];
				}
			}
		}
		return maxVal;
	}
}
