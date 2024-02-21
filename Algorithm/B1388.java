package Algorithm;

import java.util.*;
import java.io.*;

public class B1388 {
    static int n;
    static int m;
    static int[][] floor;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0}; // U,D,R,L
    static int[] dy = {0,0,1,-1}; // U,D,R,L
    static int answer;
    
    static class Node{
        int x;
        int y;

        Node(){};
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static public void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    static void solution(BufferedReader br) throws IOException{
        input(br);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false){
                    DFS(i,j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }


    static void input(BufferedReader br) throws IOException{
        answer=0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        floor = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            String com = st.nextToken();
            for(int j=0;j<m;j++){
                if(com.charAt(j)=='|'){
                    floor[i][j]=1;
                }
                else {
                    floor[i][j]=2;
                }
            }
        }
    }

    static void DFS(int x, int y){
        if(visited[x][y]==true){
            return ;
        }

        visited[x][y]=true;
        if(floor[x][y]==1){
            for(int i=0;i<2;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(floor[nx][ny]==1 && visited[nx][ny]==false){
                        DFS(nx, ny);
                    }
                }
            }
        }
        else {
            for(int i=2;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(floor[nx][ny]==2 && visited[nx][ny]==false){
                        DFS(nx, ny);
                    }
                }
            }
        }
    }
}
