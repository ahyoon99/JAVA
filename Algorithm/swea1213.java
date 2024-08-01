package Algorithm;

import java.util.*;
import java.io.*;

public class swea1213 {
    static int t;
    static String target;
    static String com;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int testcase=0;testcase<10;testcase++){
            st = new StringTokenizer(br.readLine(), " ");
            t = Integer.parseInt(st.nextToken());
            System.out.print("#"+t+" ");
            input(br, st);
            solution();
        }
    }
    static void solution(){
        int beforeLength = com.length();
        com = com.replace(target, "");
        int afterLength = com.length();
        
        int answer = (beforeLength-afterLength)/target.length();
        System.out.println(answer);
    }
    
    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        target = st.nextToken();

        st = new StringTokenizer(br.readLine(), " ");
        com = st.nextToken();
    }
}
