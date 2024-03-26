package Algorithm;

import java.util.*;
import java.io.*;

public class swea1249 {
    static int n;
    static int[][] ground;
    static int[][] distance;
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
        };
    }
    
    
    static public void main(String args[]) throws IOException{

        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());

        for(int i=0;i<C;i++){
            System.out.print("#"+(i+1)+" ");
            solution(br, st);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);

        bfs();

        System.out.println(distance[n-1][n-1]);
        
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        
        ground = new int[n][n];
        distance = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            String com = st.nextToken();
            for(int j=0;j<n;j++){
                ground[i][j]=com.charAt(j)-'0';
            }
        }
    }

    static void bfs(){
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0,0));
        visited[0][0]=true;
        distance[0][0]=0;

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<= nx && nx<n && 0<=ny  && ny<n){
                    if(distance[nx][ny]>distance[x][y]+ground[nx][ny]){
                        distance[nx][ny]=distance[x][y]+ground[nx][ny];
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
    }
}
