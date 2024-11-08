package Algorithm;

import java.util.*;
import java.io.*;

public class swea14178 {
    static int tc;
    static int n;
    static int d;
    static int[] garden;

    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        tc = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=tc;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
        }
    }

    static void solution(){
        int len = 1+2*d;
        if(n%len==0){
            System.out.println(n/len);
        }
        else{
            System.out.println((n/len)+1);
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        garden = new int[n];
    }
}
