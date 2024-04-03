package Algorithm;

import java.util.*;
import java.io.*;

public class B2636 {
    static int n;
    static int m;
    static int[][] matrix;
    static int days;
    static int cheeseCnt;
    static Queue<Node> cheese;

    static int[][] cheeseNumber;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static class Node{
        int x;
        int y;

        Node(){};
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }


    static public void main(String args[]) throws IOException{
        input();

        cheeseCnt = cheese.size();

        while(cheese.size()!=0){
            checkCheeseHole();
            meltCheese();
            days++;
            if(cheese.size()!=0){
                cheeseCnt = cheese.size();
            }
        }
        System.out.println(days);
        System.out.println(cheeseCnt);
    }

    static public void checkCheeseHole(){
        cheeseNumber=new int[n][m];
        visited = new boolean[n][m];
        int cnt = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0 && BFS(cheeseNumber, visited, i,j,0,cnt)){
                    cnt++;
                }
            }
        }
    }

    static public void meltCheese(){
        Queue<Node> tempQ = new LinkedList<>();
        boolean flag;
        for(Node node : cheese){
            int x = node.x;
            int y = node.y;
            flag=false;
            for(int j=0;j<4;j++){
                int nx = x+dx[j];
                int ny = y+dy[j];
                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(cheeseNumber[nx][ny]==1){
                        flag=true;
                        break;
                    }
                }
            }
            if(flag){
                matrix[node.x][node.y]=0;
            }
            else{
                tempQ.add(node);
            }
        }
        cheese = new LinkedList<>(tempQ);
    }

    static public boolean BFS(int[][] result, boolean[][] visited, int x, int y, int val, int cnt){
        if(result[x][y]!=0){
            return false;
        }

        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(x,y));
        visited[x][y]=true;
        result[x][y]=cnt;

        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
            y = node.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(visited[nx][ny]==false && matrix[nx][ny]==val){
                        q.add(new Node(nx, ny));
                        visited[nx][ny]=true;
                        result[nx][ny]=result[x][y];
                    }
                }
            }
        }
        return true;
    }

    static public void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        cheese = new LinkedList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++){
                if(Integer.parseInt(st.nextToken())==1){
                    matrix[i][j]=-1;
                    cheese.add(new Node(i,j));
                }
                else{
                    matrix[i][j]=0;
                }
            }
        }
        days = 0;
        cheeseCnt=0;
    }
}
