package Algorithm;

import java.util.*;
import java.io.*;

public class swea1976 {
    static int t;
    static int h1;
    static int m1;
    static int h2;
    static int m2;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br,st);
            solution();
        }
    }    

    static void solution(){
        int before = h1*60+m1;
        int plus = h2*60+m2;
        int result = before+plus;
        if(result/60 > 12){
            System.out.print(result/60 - 12);
        }
        else{
            System.out.print(result/60);
        }
        System.out.println(" " + result%60);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        h1 = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());
        h2 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
    }
}
