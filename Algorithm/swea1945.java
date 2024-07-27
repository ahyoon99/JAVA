package Algorithm;

import java.util.*;
import java.io.*;

public class swea1945 {
    static int t;
    static int n;
    static int[] result;
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
        while(n%2==0){
            n/=2;
            result[0]++;
        }

        while(n%3==0){
            n/=3;
            result[1]++;
        }

        while(n%5==0){
            n/=5;
            result[2]++;
        }

        while(n%7==0){
            n/=7;
            result[3]++;
        }

        while(n%11==0){
            n/=11;
            result[4]++;
        }

        for(int i=0;i<5;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        result = new int[5];
    }
}
