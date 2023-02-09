package Algorithm;

import java.util.*;

public class B2468 {
    static class Pair{
        int x;
        int y;

        Pair(){}
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n;

    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] height = new int[n][n];
        int maxHeight =-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int temp = sc.nextInt();
                maxHeight = (temp>maxHeight) ? temp : maxHeight;
                height[i][j]=temp;
            }
        }

        int maxSafeSection=-1;
        for(int tc=0;tc<=maxHeight;tc++){
            int safeSection=0;
            boolean[][] map = new boolean[n][n];
            boolean[][] visited = new boolean[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    map[i][j] = (height[i][j]>tc) ? true : false;
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j] && map[i][j]){
                        BFS(map, visited, i,j);
                        safeSection++;
                    }
                }
            }

            maxSafeSection = (maxSafeSection<safeSection) ? safeSection : maxSafeSection;
        }
        System.out.println(maxSafeSection);
    }
    
    static void BFS(boolean[][] map, boolean[][] visited, int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        visited[x][y]=true;

        while(!q.isEmpty()){
            Pair p = q.poll();
            x = p.x;
            y = p.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<n){
                    if(map[nx][ny]==true && visited[nx][ny]==false){
                        q.add(new Pair(nx, ny));
                        visited[nx][ny]=true;
                    }
                }
            }
        }
    }
}
