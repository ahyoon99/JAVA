package Algorithm;

import java.util.*;
import java.io.*;

public class Samsung_21_2_morning1 {
    static int n;
	static int m;
	static int[][] score;
	static int answer;
	static int dir;
	static Node current;
	static Dice dice;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static class Dice{
		int top;
		int front;
		int right;
		
		Dice(int top, int front, int right){
			this.top=top;
			this.front=front;
			this.right=right;
		}
	}
	
	static public void main(String args[]) throws IOException{
		input();
		
		for(int i=0;i<m;i++) {
			move();
			
			score();
			
			rotate();
		}
		System.out.println(answer);
	}
	
	static public void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		score = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				score[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		answer=0;
		dir=0;
		current = new Node(0,0);
		dice = new Dice(1,2,3);
	}
	
	static public void move() {
		int nx = current.x+dx[dir%4];
		int ny = current.y+dy[dir%4];
		
		if(0<= nx && nx<n && 0<=ny && ny<n) {
			current.x = nx;
			current.y = ny;
		}
		else {
			dir+=2;
			current.x = current.x+dx[dir%4];
			current.y = current.y+dy[dir%4];
		}
		
		if(dir%4==0) {
			dice = new Dice(Math.abs(7-dice.right), dice.front, dice.top);
		}
		else if(dir%4==1) {
			dice = new Dice(Math.abs(7-dice.front), dice.top, dice.right);
		}
		else if(dir%4==2) {
			dice = new Dice( dice.right, dice.front, Math.abs(7-dice.top));
		}
		else if(dir%4==3) {
			dice = new Dice(dice.front, Math.abs(7-dice.top), dice.right);
		}
		
	}
	
	static public void score() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		
		q.add(new Node(current.x, current.y));
		visited[current.x][current.y]=true;
		answer+=score[current.x][current.y];
		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					if(score[current.x][current.y]==score[nx][ny] && visited[nx][ny]==false) {
						q.add(new Node(nx, ny));
						visited[nx][ny]=true;
						answer+=score[nx][ny];
					}
				}
			}
		}
	}
	
	static public void rotate() {
		if(Math.abs(7-dice.top)>score[current.x][current.y]){
			dir+=1;
		}
		else if(Math.abs(7-dice.top)<score[current.x][current.y]){
			dir+=3;
		}
	}
}
