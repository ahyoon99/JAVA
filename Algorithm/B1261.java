package Algorithm;

import java.util.*;

public class B1261 {
    
    // 1. deque로 풀기
    // static int dx[] = {1,-1,0,0};
    // static int dy[] = {0,0,1,-1};

    // static class Pair{
    //     int x;
    //     int y;

    //     Pair(int x, int y){
    //         this.x = x;
    //         this.y = y;
    //     }
    // }
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int m = sc.nextInt();
    //     int[][] miro = new int[m][n];
    //     int[][] dist = new int[m][n];
    //     for(int i=0;i<m;i++){
    //         Arrays.fill(dist[i], -1);
    //     }


    //     for(int i=0;i<m;i++){
    //         String med =sc.next();
    //         for(int j=0;j<n;j++){
    //             miro[i][j]=med.charAt(j)-'0';
    //         }
    //     }
        
    //     Deque<Pair> deq = new ArrayDeque<>();
    //     deq.add(new Pair(0,0));
    //     dist[0][0]=miro[0][0];
    //     while(!deq.isEmpty()){
    //         Pair p = deq.remove();
    //         int x = p.x;
    //         int y = p.y;
    //         for(int i=0;i<4;i++){
    //             int nx = x+dx[i];
    //             int ny = y+dy[i];
    //             if(0<=nx && nx<m && 0<=ny && ny<n){
    //                 if(miro[nx][ny]==0 && dist[nx][ny]==-1){
    //                     deq.addFirst(new Pair(nx, ny));
    //                     dist[nx][ny]=dist[x][y];
    //                 }
    //                 else if(miro[nx][ny]==1 && dist[nx][ny]==-1){
    //                     deq.addLast(new Pair(nx, ny));
    //                     dist[nx][ny]=dist[x][y]+1;
    //                 }
    //             }
    //         }
    //     }
    //     System.out.println(dist[m-1][n-1]);
    // }

    // 2. queue 2개로 풀기
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};

    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] miro = new int[m][n];
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i], -1);
        }
        for(int i=0;i<m;i++){
            String med = sc.next();
            for(int j=0;j<n;j++){
                miro[i][j]=med.charAt(j)-'0';
            }
        }

        Queue<Pair> q1 = new LinkedList<>();
        Queue<Pair> q2 = new LinkedList<>();

        q1.add(new Pair(0,0));
        dist[0][0]=0;
        while(!q1.isEmpty()){
            Pair p = q1.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx<m && 0<=ny && ny<n){
                    if(dist[nx][ny]==-1){
                        if(miro[nx][ny]==0){
                            q1.add(new Pair(nx, ny));
                            dist[nx][ny]=dist[x][y];
                        }
                        else if(miro[nx][ny]==1){
                            q2.add(new Pair(nx, ny));
                            dist[nx][ny]=dist[x][y]+1;
                        }
                    }
                }
            }
            if(q1.isEmpty()){
                q1=q2;
                q2 = new LinkedList<>();
            }
        }
        System.out.println(dist[m-1][n-1]);
    }
    
}
