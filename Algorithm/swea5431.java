package Algorithm;

import java.util.*;
import java.io.*;

public class swea5431 {
    static int t;
    static int n;
    static int k;
    static boolean[] students;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            for(int i=1;i<=n;i++){
                if(!students[i]){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        students = new boolean[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<k;i++){
            int num = Integer.parseInt(st.nextToken());
            students[num]=true;
        }
    }
}
