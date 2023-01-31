package Algorithm;

import java.util.*;

public class B16724 {

    // 순서 : U, R, D, L
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] coordinate;

    static int n;
    static int m;

    static int safezone;

    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        char[][] map = new char[n][m];
        coordinate = new int[n][m];
        for(int i=0;i<n;i++){
            String com = sc.next();
            for(int j=0;j<m;j++){
                map[i][j]=com.charAt(j);
                if(map[i][j]=='U') coordinate[i][j]=0;
                else if(map[i][j]=='R') coordinate[i][j]=1;
                else if(map[i][j]=='D') coordinate[i][j]=2;
                else if(map[i][j]=='L') coordinate[i][j]=3;
            }
        }

        safezone=0;
        boolean[][] visited = new boolean[n][m];
        boolean[][] isCounted = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    DFS(map, visited, isCounted, i,j,-1,-1);
                }
            }
        }
        System.out.println(safezone);
    }

    static void DFS(char[][] map, boolean[][] visited, boolean[][] isCounted, int x, int y, int parentX, int parentY){
        visited[x][y]=true;
        int nx = x+dx[coordinate[x][y]];
        int ny = y+dy[coordinate[x][y]];
        
        if(!visited[nx][ny]){
            DFS(map, visited, isCounted, nx, ny, x, y);
        }
        else if(!isCounted[nx][ny]){
            safezone++;
        }
        isCounted[x][y]=true;
    }
}
