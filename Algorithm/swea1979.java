package Algorithm;

import java.util.*;
import java.io.*;

public class swea1979 {
    // 방법 2 (전치 행렬 사용)
    static int t;
    static int n;
    static int k;
    static int[][] matrix;
    static int answer;
    static int[] dxdy1 = {0,1};
    static int[] dxdy2 = {1,0};

    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
            rotate();
            solution();
            System.out.println(answer);
        }
    }

    static void solution(){
        int cnt=0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(matrix[i][j]==0){
                    if(cnt==k){
                        answer++;
                    }
                    cnt=0;
                }
                else if(matrix[i][j]==1){
                    cnt++;
                }
            }
        }
    }

    static void rotate(){
        int[][] matrix2 = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<n;j++){
                matrix2[j][i]=matrix[i][j];
            }
        }

        for(int i=0;i<=n;i++){
            matrix[i]=matrix2[i];
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        matrix = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0; 
    }

    // 방법 1
	// static int t;
    // static int n;
    // static int k;
    // static int[][] matrix;
    // static int answer;

    // static int[] dx1 = {-1,1};
    // static int[] dy1 = {0,0};
    // static int[] dx2 = {0,0};
    // static int[] dy2 = {-1,1};
    
	// public static void main(String[] args) throws IOException{
	// 	System.setIn(new FileInputStream("res/input.txt"));

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st;

    //     st = new StringTokenizer(br.readLine()," ");
    //     t = Integer.parseInt(st.nextToken());

    //     for(int testcase=1;testcase<=t;testcase++){
    //         System.out.print("#"+testcase+" ");
    //         solution(br, st);
    //         System.out.println(answer);
    //     }

	// }
	
	// static void solution(BufferedReader br, StringTokenizer st) throws IOException{
    //     input(br, st);

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             go(i,j,dx1,dy1);         
    //         }
    //     }

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             go(i,j,dx2,dy2);
    //         }
    //     }
    // }

    // static void go(int x, int y, int[] dx, int[] dy){
    //     if(matrix[x][y]==0){
    //         return;
    //     }

    //     int length=1;

    //     int nx = x+dx[0];
    //     int ny = y+dy[0];
    //     if((0<=nx && nx<n && 0<=ny && ny<n) && matrix[nx][ny]==1){
    //         return;
    //     }
        
    //     nx = x;
    //     ny = y;

    //     while(true){
    //         nx += dx[1];
    //         ny += dy[1];
    //         if(0<=nx && nx<n && 0<=ny && ny<n){
    //             if(matrix[nx][ny]==1){
    //                 length++;
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //         else{
    //             break;
    //         }
    //     }

    //     if(length==k){
    //         answer++;
    //     }
    // }

    // static void input(BufferedReader br, StringTokenizer st) throws IOException{
    //     st = new StringTokenizer(br.readLine()," ");
    //     n = Integer.parseInt(st.nextToken());
    //     k = Integer.parseInt(st.nextToken());

    //     matrix = new int[n][n];
    //     answer = 0;

    //     for(int i=0;i<n;i++){
    //         st = new StringTokenizer(br.readLine()," ");
    //         for(int j=0;j<n;j++){
    //             matrix[i][j]=Integer.parseInt(st.nextToken());
    //         }
    //     }
    // }
}
