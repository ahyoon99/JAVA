package Algorithm;

import java.util.*;
import java.io.*;

public class B2210 {
    static int[][] graph;
    static HashSet<String> hs;
    static String result;

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        graph = new int[5][5];

        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<5;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        hs = new HashSet<String>();

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                result = "";
                DFS(i,j, result);
            }
        }

        System.out.println(hs.size());

    }

    static void DFS(int x, int y, String result){
        if(result.length()==6){
            hs.add(result);
            return;
        }

        result+=String.valueOf(graph[x][y]);

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<= nx && nx<5 && 0<=ny && ny<5){
                DFS(nx, ny, result);
            }
        }
    }
}
