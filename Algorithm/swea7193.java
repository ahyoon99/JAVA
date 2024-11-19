package Algorithm;

import java.util.*;
import java.io.*;

// < 페르마의 소정리 기법 >
// n진수 x를 (n-1)로 나눈 나머지 구하기

// ex1) n = 10, x = 345
// 345 % 9 와 (3+4+5) % 9의 결과가 같다.

// ex2) n = 9, x = 234
// 234(9진수값) % 8 과 (2+3+4) % 8의 결과가 같다.

public class swea7193 {
    static int t;
    static int n;
    static String x;
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
        int total = 0;
        for(int i=0;i<x.length();i++){
            total+=(x.charAt(i)-'0');
        }
        System.out.println(total%(n-1));
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        x = st.nextToken();
    }
}
