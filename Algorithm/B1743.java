package Algorithm;

import java.util.*;

public class B1743 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static class Pair{
        int x;
        int y ;
        Pair(){}
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] ground = new int[n][m];
        
        for(int i=0;i<k;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            ground[x-1][y-1]=1;
        }

        boolean[][] visited = new boolean[n][m];
        ArrayList<Integer> componentSize = new ArrayList<>();
        int cnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cnt=0;
                if(ground[i][j]==0){
                    continue;
                }

                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i,j));
                visited[i][j]=true;
                cnt++;
                while(!q.isEmpty()){
                    Pair p = q.poll();
                    int x = p.x;    
                    int y = p.y;

                    for(int l=0;l<4;l++){
                        int nx = x+dx[l];
                        int ny = y+dy[l];
                        if(0<=nx && nx<n && 0<=ny && ny<m){
                            if(ground[nx][ny]==1 && visited[nx][ny]==false){
                                q.add(new Pair(nx, ny));
                                visited[nx][ny]=true;
                                cnt++;
                            }
                        }
                    }
                }
                componentSize.add(cnt);
            }
        }
        Collections.sort(componentSize, Comparator.reverseOrder());
        System.out.println(componentSize.get(0));
    }
}
