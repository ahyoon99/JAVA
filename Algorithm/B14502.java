package Algorithm;

import java.util.*;

public class B14502 {

    static int n;
    static int m;
    static int[][] map;
    static int maxSafezone=-1;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static class Pair{
        int x;
        int y;

        Pair(){}
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=sc.nextInt();
            }
        }

        // 1. DFS 방법으로 벽 세우기
        // 2. 바이러스 퍼뜨리기 (BFS)
        // 3. 0의 개수 세기
        // 4. 0의 개수 최대값 출력하기
        
        dfs(0);
        System.out.println(maxSafezone);
    }

    static void dfs(int cnt){
        if(cnt==3){
            bfs();
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(cnt+1);
                    map[i][j]=0;
                }
            }
        }
    }

    static void bfs(){
        int[][] virusMap = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                virusMap[i][j]=map[i][j];
                if(map[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(virusMap[nx][ny]==0 && visited[nx][ny]==false){
                        virusMap[nx][ny]=2;
                        visited[nx][ny]=true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        int safezone=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(virusMap[i][j]==0){
                    safezone++;
                }
            }
        }

        if(maxSafezone<safezone){
            maxSafezone=safezone;
        }
    }
}
