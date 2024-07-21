package Algorithm;

import java.util.*;
import java.io.*;

public class swea2005 {
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
        for(int i=2;i<n;i++){
            for(int j=1;j<i;j++){
                matrix[i][j]=matrix[i-1][j-1]+matrix[i-1][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        for(int i=0;i<n;i++){
            matrix[i][0]=1;
            matrix[i][i]=1;
        }

    }
}
