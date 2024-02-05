package Algorithm;

import java.util.*;
import java.io.*;

public class swea2805 {

    static int T;
    static int n;
    static int[][] board;
    static int result;
    static public void main(String args[]) throws Exception{

        System.setIn(new FileInputStream("res/input_swea2805.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());

        for(int test_case=0;test_case<T;test_case++){
            System.out.print("#"+(test_case+1)+" ");
            solution(br, st);
        }
        
    }
    
    static public void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);

        for(int i=0;i<n/2;i++){
            for(int j=n/2-i;j<=n/2+i;j++){
                result += board[i][j];
                result += board[n-i-1][j];
            }
        }

        for(int i=0;i<n;i++){
            result += board[n/2][i];
        }
        System.out.println(result);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            String temp = st.nextToken();
            for(int j=0;j<n;j++){
                board[i][j]=temp.charAt(j)-'0';
            }
        }
        result = 0;
    }
}
