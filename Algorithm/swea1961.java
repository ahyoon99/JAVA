package Algorithm;

import java.util.*;
import java.io.*;

public class swea1961 {
    static int t;
    static int n;
    static int[][] matrix;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=t;testcase++){
            System.out.println("#"+testcase);
            input(br, st);
            solution();
        }
    }

    static void solution(){
        int[][] result90 = new int[n][n];
        int[][] result180 = new int[n][n];
        int[][] result270 = new int[n][n];

        rotate90(matrix, result90);
        rotate90(result90, result180);
        rotate90(result180, result270);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(result90[i][j]);
            }
            System.out.print(" ");
            for(int j=0;j<n;j++){
                System.out.print(result180[i][j]);
            }
            System.out.print(" ");
            for(int j=0;j<n;j++){
                System.out.print(result270[i][j]);
            }
            System.out.println();
        }
    }

    static void rotate90(int[][] before, int[][] after){
        for(int i=0;i<n;i++){
            after[i][n-1]=before[0][i];
        }

        for(int i=1;i<n-1;i++){
            for(int j=0;j<n;j++){
                after[j][n-i-1] = before[i][j];
            }
        }

        for(int i=0;i<n;i++){
            after[i][0] = before[n-1][i];
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
    }
}
