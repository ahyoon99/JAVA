package Algorithm;

import java.util.*;
import java.io.*;

public class swea1959 {
    static int t;
    static int n;
    static int m;
    static int[] small;
    static int[] big;
    static int answer;

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
        }
    }

    static void solution(){
        for(int i=0;i<=big.length-small.length;i++){
            int num=0;
            for(int j=0;j<small.length;j++){
                num+=(small[j]*big[i+j]);
            }
            if(num>answer){
                answer=num;
            }
        }
        System.out.println(answer);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if(n<m){
            small = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0;i<n;i++){
                small[i]=Integer.parseInt(st.nextToken());
            }

            big = new int[m];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0;i<m;i++){
                big[i]=Integer.parseInt(st.nextToken());
            }
        }
        else{
            big = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0;i<n;i++){
                big[i]=Integer.parseInt(st.nextToken());
            }

            small = new int[m];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0;i<m;i++){
                small[i]=Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MIN_VALUE;
    }
}
