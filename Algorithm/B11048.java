package Algorithm;

import java.util.*;

public class B11048 {

    // 방법 1 : Bottom up
    static int[] dx = {1,0,1};
    static int[] dy = {0,1,1};
    
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=sc.nextInt();
            }
        }

        int[][] result = new int[n][m];
        result[0][0]=map[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<3;k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(0<=nx && nx<n && 0<=ny && ny<m){
                        if(result[nx][ny]<result[i][j]+map[nx][ny]){
                            result[nx][ny]=result[i][j]+map[nx][ny];
                        }
                    }
                }
            }
        }
        System.out.println(result[n-1][m-1]);
    }
}
