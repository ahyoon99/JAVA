package Algorithm;

import java.util.*;

public class B2206 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static class Tuple{
        int x;
        int y;
        int z;
        Tuple(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] miro = new int[n][m];
        int[][][] dist = new int[n][m][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dist[i][j],-1);
            }
        }
        
        for(int i=0;i<n;i++){
            String med = sc.next();
            for(int j=0;j<m;j++){
                miro[i][j]=med.charAt(j)-'0';
            }
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,0));
        dist[0][0][0]=1;

        while(!q.isEmpty()){
            Tuple p = q.poll();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(miro[nx][ny]==0 && dist[nx][ny][z]==-1){
                        q.add(new Tuple(nx, ny, z));
                        dist[nx][ny][z]=dist[x][y][z]+1;
                    }
                    if(z==0 && miro[nx][ny]==1 && dist[nx][ny][z+1]==-1){
                        q.add(new Tuple(nx, ny,z+1));
                        dist[nx][ny][z+1]=dist[x][y][z]+1;
                    }
                }
            }
        }

        if(dist[n-1][m-1][0]==-1 && dist[n-1][m-1][1]==-1){
            System.out.println("-1");
        }
        else if(dist[n-1][m-1][0]!=-1 && dist[n-1][m-1][1]!=-1){
            System.out.println(Math.min(dist[n-1][m-1][0], dist[n-1][m-1][1]));
        }
        else if(dist[n-1][m-1][0]==-1){
            System.out.println(dist[n-1][m-1][1]);
        }
        else if(dist[n-1][m-1][1]==-1){
            System.out.println(dist[n-1][m-1][0]);
        }
    }

}
