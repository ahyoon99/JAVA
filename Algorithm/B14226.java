package Algorithm;

import java.util.*;

public class B14226 {
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[][] d = new int[1001][1001];

        for(int i=0;i<1001;i++){
            Arrays.fill(d[i], -1);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,0));
        d[1][0]=0;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            
            // 1. 이모티콘 복사
            int nx = x;
            int ny = x;
            if(0<=nx && nx<1001 && 0<=ny && ny<1001 && d[nx][ny]==-1){
                q.add(new Pair(nx, ny));
                d[nx][ny]=d[x][y]+1;
            }

            // 2. 이모티콘 붙여넣기
            nx = x+y;
            ny = y;
            if(0<=nx && nx<1001 && 0<=ny && ny<1001 && d[nx][ny]==-1){
                q.add(new Pair(nx, ny));
                d[nx][ny]=d[x][y]+1;
            }

            // 3. 이모티콘 하나 삭제
            nx = x-1;
            ny = y;
            if(0<=nx && nx<1001 && 0<=ny && ny<1001 && d[nx][ny]==-1){
                q.add(new Pair(nx, ny));
                d[nx][ny]=d[x][y]+1;
            }
        }

        int min = 10000000;
        for(int i=0;i<1001;i++){
            if(d[s][i]!=-1 && d[s][i]<min){
                min = d[s][i];
            }
        }
        System.out.println(min);
    }
    
}
