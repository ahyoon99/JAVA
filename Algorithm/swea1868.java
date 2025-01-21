package Algorithm;

import java.util.*;
import java.io.*;

public class swea1868 {
    static int tc;
    static int n;
    static int[][] matrix;
    static int[][] mineCnt;

    static ArrayList<Node> zeroNodes;
    static Queue<Node> q;
    static int result;

    static int[] dx = {-1,-1,-1,0,1,1,1,0};
    static int[] dy = {-1,0,1,1,1,0,-1,-1};

    static class Node{
        int x;
        int y;

        Node(){}
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        tc = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=tc;testcase++) {
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
        }
    }

    static void solution() {
        countMine();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mineCnt[i][j]==0 && matrix[i][j]==-2){
                    calculate(i, j);
                    mineCnt[i][j]=-1;
                    result++;
                }
            }
        }

	    find();
	    System.out.println(result);
	}
	
	static void find() {
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
	            if(matrix[i][j]==-2 && mineCnt[i][j]!=-1) {
	                result++;
	            }
	        }
	    }
	}
	
	// 지뢰 세기   
	static void countMine() {
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
	            if(matrix[i][j]==-1) {
	                continue;
	            }
	            int cnt=0;
	            for(int k=0;k<8;k++) {
	                if(!isValid(i+dx[k], j+dy[k]) || matrix[i+dx[k]][j+dy[k]]==-2) {
	                    continue;
	                }
	                cnt++;
	            }
	            mineCnt[i][j]=cnt;
	        }
	    }
	}
	
	static void calculate(int x, int y){
	    q.add(new Node(x,y));
	
	    while(!q.isEmpty()){
	        Node node = q.poll();
	        x=node.x;
	        y=node.y;
	
	        for(int i=0;i<8;i++){
	            int nx = x+dx[i];
	            int ny = y+dy[i];
	            if(!isValid(nx, ny)){
	                continue;
	            }
	            if(matrix[nx][ny]==-2 && mineCnt[nx][ny]!=-1){
	                if(mineCnt[nx][ny]==0){
	                    q.add(new Node(nx, ny));
	                }
	                mineCnt[nx][ny]=-1;
	            }
	        }
	    }
	}
	
	static boolean isValid(int x, int y) {
	    if(0<=x && x<n && 0<=y && y<n) {
	        return true;
	    }
	    return false;
	}
	
	// 지뢰 : -1, 나머지 : -2
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
	    st = new StringTokenizer(br.readLine(), " ");
	    n = Integer.parseInt(st.nextToken());
	    matrix = new int[n][n];
	    
	    for(int i=0;i<n;i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        String com = st.nextToken();
	        for(int j=0;j<n;j++) {
	            if(com.charAt(j)=='*') {
	                matrix[i][j]=-1;
	            }
	            else{
	                matrix[i][j]=-2;
	            }
	        }
	    }
	    mineCnt = new int[n][n];
	    zeroNodes = new ArrayList<>();
	    q = new LinkedList<>();
	    result = 0;
	}
	
	static void print() {
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
	            System.out.print(matrix[i][j]+" ");
	        }
	        System.out.println();
	    }
	}
}

