package Algorithm;

import java.util.*;
import java.io.*;

public class swea1954 {
    // 방법 1
    // static int n;
    // static int[][] answer;
    // static int start;
    // static public void main(String args[]) throws IOException{
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st;

    //     st = new StringTokenizer(br.readLine(), " ");
    //     int T = Integer.parseInt(st.nextToken());

    //     for(int test_case = 1; test_case<= T ; test_case++){
    //         System.out.println("#"+test_case);
    //         solution(br, st);
    //     }
    // }  
    
    // static public void solution(BufferedReader br, StringTokenizer st) throws IOException{
    //     input(br, st);

    //     int cnt=0;
    //     for(int i=n;i>0;i-=2){
    //         if(n==1){
    //             answer[cnt][cnt]=start;
    //         }
    //         else{
    //             int[][] temp = go(i);

    //             for(int j=0;j<temp.length;j++){
    //                 for(int k=0;k<temp.length;k++){
    //                     answer[j+cnt][k+cnt]=temp[j][k];
    //                 }
    //             }
    //         }
    //         cnt++;
    //     }

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             System.out.print(answer[i][j]+" ");
    //         }
    //         System.out.println();
    //     }

    // }

    // static public void input(BufferedReader br, StringTokenizer st) throws IOException{
    //     st = new StringTokenizer(br.readLine(), " ");
    //     n = Integer.parseInt(st.nextToken());
    //     answer = new int[n][n];
    //     start=1;
    // }

    // static public int[][] go(int n){
    //     int[][] temp = new int[n][n];
    //     for(int i=0;i<n;i++){
    //         temp[0][i]=start;
    //         start++;
    //     }

    //     for(int i=1;i<n;i++){
    //         temp[i][n-1]=start;
    //         start++;
    //     }

    //     for(int i=n-2;i>=0;i--){
    //         temp[n-1][i]=start;
    //         start++;
    //     }

    //     for(int i=n-2;i>0;i--){
    //         temp[i][0]=start;
    //         start++;
    //     }
    //     return temp;
    // }

    // 방법 2
    static int n;
    static int[][] board;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        for(int test_case = 1; test_case<= T ; test_case++){
            System.out.println("#"+test_case);
            solution(br, st);
        }
    }

    static public void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);

        int dir=0;
        int x = 0;
        int y = 0;
        int num=1;
        for(int i=0;i<n*n;i++){
            board[x][y]=num;
            if(!isRangeOf(x+dx[dir%4], y+dy[dir%4]) || board[x+dx[dir%4]][y+dy[dir%4]]!=-1){
                dir++;
            }
            x +=dx[dir%4];
            y +=dy[dir%4];
            num++;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    static public void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],-1);
        }
    }

    static public boolean isRangeOf(int x, int y){
        if(0<=x && x<n && 0<=y && y<n){
            return true;
        }
        return false;
    }
}
