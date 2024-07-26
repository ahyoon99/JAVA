package Algorithm;

import java.util.*;
import java.io.*;

// swea1948 날짜 계산기
public class swea1948 {
    static int t;
    static int m1;
    static int d1;
    static int m2;
    static int d2;
    static int[] days;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        days = new int[]{0,31,59,90,120,151,181,212,243,273,304,334,365};

        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
        }
    }

    static void solution(){
        int num1 = days[m1-1]+d1;
        int num2 = days[m2-1]+d2;
        System.out.println(num2-num1+1);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        m1 = Integer.parseInt(st.nextToken());
        d1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        d2 = Integer.parseInt(st.nextToken());
    }
}
