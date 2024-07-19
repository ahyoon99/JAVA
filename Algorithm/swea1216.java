package Algorithm;

import java.util.*;
import java.io.*;

public class swea1216 {
    static int n;
    static char[][] matrix;
    static int answer;
    
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        for(int testcase=1;testcase<=10;testcase++){
            st = new StringTokenizer(br.readLine(), " "); // testcase 번호
            int num = Integer.parseInt(st.nextToken());
            System.out.print("#"+num+" ");
            input(br, st);
            solution();
        }
    }

    static void solution(){
        // 전치행렬 만들기
        char[][] matrixInv = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrixInv[j][i]=matrix[i][j];
            }
        }

        for(int len=n;len>=1;len--){
            if(answer>=len){
                break;
            }
            find(matrix, len);
            find(matrixInv, len);
        }
        System.out.println(answer);
    }

    static void find(char[][] matrix, int len){
        for(char[] arr : matrix){
            for(int i=0;i<n-len+1;i++){
                if(isPalindrome(arr, i, i+len-1, len)){
                    if(len>answer){
                        answer=len;
                    }
                }
            }
        }
    }

    static boolean isPalindrome(char[] arr, int startIdx, int endIdx, int len){
        for(int i=0;i<len/2;i++){
            if(arr[startIdx+i]!=arr[endIdx-i]){
                return false;
            }
        }
        return true;
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        n = 100;
        matrix = new char[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            String temp = st.nextToken();
            for(int j=0;j<n;j++){
                matrix[i][j] = temp.charAt(j);
            }
        }
        answer = Integer.MIN_VALUE;
    }
}
