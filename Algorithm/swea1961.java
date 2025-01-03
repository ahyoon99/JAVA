package Algorithm;

import java.util.*;
import java.io.*;

public class swea1961 {
    // 방법 1
    // static int t;
    // static int n;
    // static int[][] matrix;
    // static public void main(String args[]) throws IOException{
    //     System.setIn(new FileInputStream("res/input.txt"));

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st;

    //     st = new StringTokenizer(br.readLine(), " ");
    //     t = Integer.parseInt(st.nextToken());

    //     for(int testcase=1;testcase<=t;testcase++){
    //         System.out.println("#"+testcase);
    //         input(br, st);
    //         solution();
    //     }
    // }

    // static void solution(){
    //     int[][] result90 = new int[n][n];
    //     int[][] result180 = new int[n][n];
    //     int[][] result270 = new int[n][n];

    //     rotate90(matrix, result90);
    //     rotate90(result90, result180);
    //     rotate90(result180, result270);

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             System.out.print(result90[i][j]);
    //         }
    //         System.out.print(" ");
    //         for(int j=0;j<n;j++){
    //             System.out.print(result180[i][j]);
    //         }
    //         System.out.print(" ");
    //         for(int j=0;j<n;j++){
    //             System.out.print(result270[i][j]);
    //         }
    //         System.out.println();
    //     }
    // }

    // static void rotate90(int[][] before, int[][] after){
    //     for(int i=0;i<n;i++){
    //         after[i][n-1]=before[0][i];
    //     }

    //     for(int i=1;i<n-1;i++){
    //         for(int j=0;j<n;j++){
    //             after[j][n-i-1] = before[i][j];
    //         }
    //     }

    //     for(int i=0;i<n;i++){
    //         after[i][0] = before[n-1][i];
    //     }
    // }

    // static void input(BufferedReader br, StringTokenizer st) throws IOException{
    //     st = new StringTokenizer(br.readLine(), " ");
    //     n = Integer.parseInt(st.nextToken());
    //     matrix = new int[n][n];
        
    //     for(int i=0;i<n;i++){
    //         st = new StringTokenizer(br.readLine(), " ");
    //         for(int j=0;j<n;j++){
    //             matrix[i][j] = Integer.parseInt(st.nextToken());
    //         }
    //     }
    // }

    // 방법 2
    static int tc;
    static int n;
    static int[][] matrix;
    static String[][] result;
    static public void main(String args[]) throws IOException{

        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        tc = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=tc;testcase++){
            System.out.println("#"+testcase);
            solution(br, st);
        }
        
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);
        rotateRight(0);
        rotateRight(1);
        rotateRight(2);

        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void rotateRight(int cnt){
        int[][] after = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                after[j][n-i-1]=matrix[i][j];
            }
        }

        for(int i=0;i<n;i++){
            String temp  = "";
            for(int j=0;j<n;j++){
                temp+=String.valueOf(after[i][j]);
            }
            result[i][cnt]=temp;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=after[i][j];
            }
        }
        
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        result = new String[n][3];
    }
}
