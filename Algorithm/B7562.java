package Algorithm;

import java.util.*;
import java.io.*;

public class B7562 {
    static int l;
    static Node start;
    static Node end;
    static int answer;
    static int[][] matrix;

    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    
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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int tc = Integer.parseInt(st.nextToken());

        for(int testcase=0;testcase<tc;testcase++){
            solution(br, st);
        }
    }

    static public void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);

        bfs();
        System.out.println(matrix[end.x][end.y]);

    }

    static public void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        matrix[start.x][start.y]=0;

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            if(x==end.x && y==end.y){
                break;
            }
            for(int i=0;i<8;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<l && 0<=ny && ny<l){
                    if(matrix[nx][ny]==-1){
                        matrix[nx][ny]=matrix[x][y]+1;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
    }

    static public void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine()," ");
        l = Integer.parseInt(st.nextToken());

        matrix = new int[l][l];
        for(int i=0;i<l;i++){
            Arrays.fill(matrix[i],-1);
        }

        st = new StringTokenizer(br.readLine()," ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        start = new Node(x,y);

        st = new StringTokenizer(br.readLine()," ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        end = new Node(x,y);

        answer=0;
    }
}
