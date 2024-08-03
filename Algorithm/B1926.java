package Algorithm;

import java.util.*;
import java.io.*;

public class B1926 {
    static int n;
    static int m;
    static int[][] matrix;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int count;
    
    static class Node{
        int x;
        int y;
        Node(){}
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        solution();
    }

    static void solution(){
        int num=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(bfs(i,j,num)){
                    num++;
                }
            }
        }
        System.out.println(num-1);
        System.out.println(count);
        
    }

    static boolean bfs(int x, int y, int num){
        if(matrix[x][y]>=0){
            return false;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y]=true;
        matrix[x][y]=num;
        int cnt=1;

        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
            y = node.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<= nx && nx<n && 0<=ny && ny<m){
                    if(visited[nx][ny]==false && matrix[nx][ny]==-1){
                        visited[nx][ny]=true;
                        matrix[nx][ny]=num;
                        q.add(new Node(nx, ny));
                        cnt++;
                    }
                }
            }
        }
        if(count<cnt){
            count=cnt;
        }
        return true;
    }

    static void input(BufferedReader br) throws IOException{
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        visited = new boolean[n][m];
        count = 0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j]==1){
                    matrix[i][j]=-1;
                }
            }
        }
    }
}
