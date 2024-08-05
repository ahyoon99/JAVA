package Algorithm;

import java.util.*;
import java.io.*;

public class swea1284 {
    static int t;
    static int p;
    static int q;
    static int r;
    static int s;
    static int w;
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
        int a = w*p;
        int b = -1;
        if(w<=r){
            b = q;
        }
        else{
            b = q+(w-r)*s;
        }
        System.out.println(Math.min(a,b));
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
    }   
}
