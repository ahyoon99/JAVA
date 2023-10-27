package Algorithm;

import java.util.*;
import java.io.*;

public class swea1954 {
    static int n;
    static int[][] answer;
    static int start;
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

        int cnt=0;
        for(int i=n;i>0;i-=2){
            if(n==1){
                answer[cnt][cnt]=start;
            }
            else{
                int[][] temp = go(i);

                for(int j=0;j<temp.length;j++){
                    for(int k=0;k<temp.length;k++){
                        answer[j+cnt][k+cnt]=temp[j][k];
                    }
                }
            }
            cnt++;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }

    }

    static public void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        answer = new int[n][n];
        start=1;
    }

    static public int[][] go(int n){
        int[][] temp = new int[n][n];
        for(int i=0;i<n;i++){
            temp[0][i]=start;
            start++;
        }

        for(int i=1;i<n;i++){
            temp[i][n-1]=start;
            start++;
        }

        for(int i=n-2;i>=0;i--){
            temp[n-1][i]=start;
            start++;
        }

        for(int i=n-2;i>0;i--){
            temp[i][0]=start;
            start++;
        }
        return temp;
    }
}
