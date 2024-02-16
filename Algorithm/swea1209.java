package Algorithm;

import java.util.*;
import java.io.*;

public class swea1209 {
    static int[][] ground;
    static int maxValue;
    static public void main(String args[]) throws IOException{
        
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0;i<10;i++){
            st = new StringTokenizer(br.readLine(), " ");
            System.out.print("#"+Integer.parseInt(st.nextToken())+" ");
            solution(br, st);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);

        // 가로의 합
        for(int i=0;i<100;i++){
            int med = 0;
            for(int j=0;j<100;j++){
                med += ground[i][j];
            }
            maxValue = Math.max(maxValue, med);
        }

        // 세로의 합
        for(int i=0;i<100;i++){
            int med = 0;
            for(int j=0;j<100;j++){
                med += ground[j][i];
            }
            maxValue = Math.max(maxValue, med);
        }

        // 하강 대각선의 합
        int med =0;
        for(int i=0;i<100;i++){
            med+=ground[i][i];
        }
        maxValue = Math.max(maxValue, med);

        // 상승 대각선의 합
        med = 0;
        for(int i=99;i>=0;i--){
            med+=ground[i][i];
        }
        maxValue = Math.max(maxValue, med);

        System.out.println(maxValue);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        ground = new int[100][100];
        maxValue=-1;
        for(int i=0;i<100;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<100;j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
