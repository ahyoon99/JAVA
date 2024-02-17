package Algorithm;

import java.util.*;
import java.io.*;

public class swea1226 {
    static int[][] ground;
    static int[][] distance;
    static Node startPoint;
    static Node endPoint;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static class Node{
        int x;
        int y;
        Node(){};
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<10;i++){
            st = new StringTokenizer(br.readLine(), " ");
            System.out.print("#"+Integer.parseInt(st.nextToken())+" ");
            solution(br, st);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);

        BFS();

        if(distance[endPoint.x][endPoint.y]==-1 || distance[endPoint.x][endPoint.y] == 0){
            System.out.println(0);
        }
        else{
            System.out.println(1);
        }

    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        ground = new int[16][16];
        distance = new int[16][16];
        for(int i=0;i<16;i++){
            st = new StringTokenizer(br.readLine(), " ");
            String oneLine = st.nextToken();
            for(int j=0;j<16;j++){
                int num = oneLine.charAt(j)-'0';
                if(num==1){
                    ground[i][j]=-1;
                }
                else if(num==0){
                    ground[i][j]=0;
                }
                else if(num==2){
                    ground[i][j]=0;
                    startPoint = new Node(i,j);
                }
                else if(num==3){
                    ground[i][j]=0;
                    endPoint = new Node(i,j);
                }
            }
        }
    }

    static void BFS(){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[16][16];
        q.add(startPoint);
        visited[startPoint.x][startPoint.y]=true;
        distance[startPoint.x][startPoint.y]=1;

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<16 && 0<= ny && ny<16){
                    if(visited[nx][ny]==false && ground[nx][ny]==0){
                        q.add(new Node(nx, ny));
                        visited[nx][ny]=true;
                        distance[nx][ny]=distance[x][y]+1;
                    }
                }
            }
        }
    }

}
