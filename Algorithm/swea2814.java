package Algorithm;

import java.util.*;
import java.io.*;

public class swea2814 {
    static int t;
    static int n;
    static int m;
    static int[][] matrix;
    static int answer;
    static int[] distance;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());
        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br,st);
            
            distance = new int[n+1];
            Arrays.fill(distance, -1);

            for(int i=1;i<=n;i++){
                distance[i]=1;
                dfsByRecursion(i, 1);
                distance[i]=-1;
            }
            System.out.println(answer);
        }
    }

    static void dfsByRecursion(int v, int cnt){
        answer = Math.max(answer, cnt);
        for(int i=1;i<=n;i++){
            if(matrix[v][i]==1 && distance[i]==-1){
                distance[i]=cnt+1;
                dfsByRecursion(i, cnt+1);
                distance[i]=-1;
            }
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n+1][n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            matrix[start][end]=1;
            matrix[end][start]=1;
        }
        answer = Integer.MIN_VALUE;
    }
}
