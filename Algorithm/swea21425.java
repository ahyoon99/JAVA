package Algorithm;

import java.util.*;
import java.io.*;

public class swea21425 {
    static int t;
    static int a;
    static int b;
    static int n;
    static int answer;

    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=t;testcase++){
            input(br, st);
            solution();
        }
    }    

    static void solution(){
        go(Math.min(a, b), Math.max(a, b));
    }

    static void go(int x, int y){
        if(x>n || y>n){
            System.out.println(answer);
            return;
        }
        answer++;
        go(y, x+y);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        answer = 0;
    }
}
