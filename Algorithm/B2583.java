package Algorithm;

import java.util.*;

public class B2583 {

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
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] rect = new int[n][m];
        for(int i=0;i<k;i++){
            int prevX1 = sc.nextInt();
            int prevY1 = sc.nextInt();
            int x1 = n-prevY1-1;
            int y1 = prevX1; 

            int prevX2 = sc.nextInt();
            int prevY2 = sc.nextInt();
            int x2 = n-prevY2;
            int y2 = prevX2-1;

            for(int j=x2;j<=x1;j++){
                for(int l=y1;l<=y2;l++){
                    rect[j][l]=1;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        
        int group=0;
        ArrayList<Integer> groupCnt = new ArrayList<>();
        int total=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] || rect[i][j]==1){
                    continue;
                }
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i,j));
                visited[i][j]=true;
                total=1;
                group++;

                while(!q.isEmpty()){
                    Pair p = q.poll();
                    int x = p.x;
                    int y = p.y;
                    for(int l=0;l<4;l++){
                        int nx = x+dx[l];
                        int ny = y+dy[l];
                        if(0<=nx && nx<n && 0<=ny && ny<m){
                            if(rect[nx][ny]==0 && visited[nx][ny]==false){
                                q.add(new Pair(nx, ny));
                                visited[nx][ny]=true;
                                total++;
                            }
                        }
                    }
                }
                if(total!=0){
                    groupCnt.add(total);
                }
            }
        }

        System.out.println(group);
        Collections.sort(groupCnt);
        for(int i=0;i<groupCnt.size();i++){
            System.out.print(groupCnt.get(i)+" ");
        }
    }
}
