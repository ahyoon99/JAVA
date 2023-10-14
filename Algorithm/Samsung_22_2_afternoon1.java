package Algorithm;

import java.util.*;
import java.io.*;

public class Samsung_22_2_afternoon1 {
    static int time;
	static int n;
	static int m;
	static int finishCnt;
	static int[][] ground;
	static int[][] medDistance;
	static boolean[][] visited;
	static ArrayList<Node> stores;
	static ArrayList<Node> basecamps;
	static ArrayList<Node> people;
	
	
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}

    static public void main(String args[]) throws IOException{
		input();
		
		while(finishCnt<m) {
			if(time!=0) {
				move();
			}
			
			enterBaseCamp();
			
			time++;
		}
		
		System.out.println(time);
	}
	
	static public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		stores = new ArrayList<Node>();
		basecamps = new ArrayList<Node>();
		people = new ArrayList<Node>();
		
		ground = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				ground[i][j]=Integer.parseInt(st.nextToken());
				if(ground[i][j]==1) {
					basecamps.add(new Node(i,j));
					ground[i][j]=-1;
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			ground[x][y]=-2;
			stores.add(new Node(x,y));
		}
		
		time=0;
		finishCnt=0;
	}
	
	static public void move() {
		for(int tc = 0;tc<people.size();tc++) {
			int x = people.get(tc).x;
			int y = people.get(tc).y;
			
			int sx = stores.get(tc).x;
			int sy = stores.get(tc).y;
			
			if(x==sx && y==sy) {
				continue;
			}

			bfs(sx,sy);
			Node after = new Node(-1,-1);
			int minVal = Integer.MAX_VALUE;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx &&nx<n && 0<=ny && ny<n) {
					if(ground[nx][ny]!=-3 && visited[nx][ny] && medDistance[nx][ny]<minVal) {
						minVal = medDistance[nx][ny];
						after.x=nx;
						after.y=ny;
					}
				}
			}
			people.set(tc,  after);
			
			if(people.get(tc).x == stores.get(tc).x && people.get(tc).y == stores.get(tc).y) {
				ground[people.get(tc).x][people.get(tc).y]=-3;
				finishCnt++;
			}
		}
	}

	static public void enterBaseCamp() {
		if(time<m) {
			Node store = stores.get(time);
			bfs(store.x, store.y);
			
			int minLen = Integer.MAX_VALUE;
			Node myBaseCamp = new Node(-1,-1);
			for(Node node : basecamps) {
				if(medDistance[node.x][node.y]!=0 && minLen>medDistance[node.x][node.y]) {
					minLen=medDistance[node.x][node.y];
					myBaseCamp = new Node(node.x, node.y);
				}
			}
			ground[myBaseCamp.x][myBaseCamp.y]=-3;
			people.add(new Node(myBaseCamp.x, myBaseCamp.y));
		}
		
	}
	
	static public void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		visited = new boolean[n][n];
		medDistance = new int[n][n];
		q.add(new Node(x,y));
		visited[x][y]=true;
		medDistance[x][y]=0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<= nx && nx<n && 0<=ny && ny<n) {
					if(ground[nx][ny]!=-3 && visited[nx][ny]==false) {
						q.add(new Node(nx, ny));
						visited[nx][ny]=true;
						medDistance[nx][ny]=medDistance[x][y]+1;
					}
				}
			}
		}
	}

}
