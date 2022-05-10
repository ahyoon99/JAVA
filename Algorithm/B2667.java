package Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2667 {

    // 방법 1 : BFS
    // static class Pair{
    //     int x;
    //     int y;
    //     Pair(int x, int y){
    //         this.x=x;
    //         this.y=y;
    //     }
    // }

    // static int[] dx = {1,-1,0,0};
    // static int[] dy = {0,0,1,-1};
    // static int[] count = new int[1000];

    // static public void BFS(int[][] town, int[][] townNum, int x, int y, int cnt){
    //     Queue<Pair> q = new LinkedList<>();
    //     q.add(new Pair(x,y));
    //     townNum[x][y]=cnt;  // 단지 번호 붙이기
    //     count[cnt]=1;

    //     while(!q.isEmpty()){
    //         x = q.peek().x;
    //         y = q.peek().y;
    //         q.poll();
    //         for(int i=0;i<4;i++){
    //             int nx = x+dx[i];
    //             int ny = y+dy[i];
    //             if(0<=nx && nx<town.length && 0<=ny && ny<town.length){
    //                 if(town[nx][ny]==1 && townNum[nx][ny]==0){
    //                     q.add(new Pair(nx, ny));
    //                     townNum[nx][ny]=cnt;
    //                     count[cnt]++;
    //                 }
    //             }
    //         }
    //     }
    // }
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[][] town = new int[n][n];
    //     int[][] townNum = new int[n][n];
    //     for(int i=0;i<n;i++){
    //         String row = sc.next();
    //         for(int j=0;j<n;j++){
    //             town[i][j]=row.charAt(j)-'0';
    //         }
    //     }

    //     int cnt=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             if(town[i][j]==1 && townNum[i][j]==0){
    //                 BFS(town, townNum, i,j,++cnt);
    //             }
    //         }
    //     }

    //     System.out.println(cnt);
    //     Arrays.sort(count, 1, cnt+1);
    //     for(int i=1;i<=cnt;i++){
    //         System.out.println(count[i]);
    //     }


    // }

    // 방법 2 : DFS
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static public void DFS(int[][] town, int[][] townNum, int x, int y, int cnt){
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<town.length && 0<=ny && ny<town.length){
                if(town[nx][ny]==1 && townNum[nx][ny]==0){
                    townNum[nx][ny]=cnt;
                    DFS(town, townNum, nx,ny,cnt);
                }
            }
        }
    }

    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] town = new int[n][n];
        int[][] townNum = new int[n][n];
        
        for(int i=0;i<n;i++){
            String com = sc.next();
            for(int j=0;j<n;j++){
                town[i][j]=com.charAt(j)-'0';
            }
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(town[i][j]==1 && townNum[i][j]==0){
                    cnt++;
                    townNum[i][j]=cnt;
                    DFS(town, townNum, i,j,cnt);
                }
            }
        }

        int[] townCnt = new int[cnt];
        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(townNum[i][j]!=0){
                    townCnt[townNum[i][j]-1]++;
                }
            }
        }

        System.out.println(cnt);
        Arrays.sort(townCnt);
        for(int i=0;i<cnt;i++){
            System.out.println(townCnt[i]);
        }
    }
}
