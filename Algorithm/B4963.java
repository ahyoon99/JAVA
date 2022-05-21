package Algorithm;

import java.util.*;

public class B4963 {

    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,-1,1,1,-1};

    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static public boolean BFS(int[][] map, int[][] island, int x, int y, int cnt){
        if(map[x][y]==0 || island[x][y]!=0){
            return false;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        island[x][y]=cnt;
        while(!q.isEmpty()){
            x = q.peek().x;
            y = q.peek().y;
            q.poll();
            for(int i=0;i<8;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<map.length && 0<=ny && ny<map[0].length && map[nx][ny]==1 && island[nx][ny]==0){
                    q.add(new Pair(nx, ny));
                    island[nx][ny]=island[x][y]+1;
                }
            }
        }
        return true;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            int w = sc.nextInt();
            int h = sc.nextInt();
            if(w==0 && h==0){
                break;
            }
            int[][] map = new int[h][w];
            int[][] island = new int[h][w];
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    map[i][j]=sc.nextInt();
                }
            }
            int cnt = 1;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(BFS(map, island, i,j,cnt)){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt-1);
        }
    }
    
}
