package Algorithm;

import java.util.*;
import java.io.*;

public class swea3431 {
    static int T;
    static int l;
    static int u;
    static int x;
    
    static public void main(String args[]) throws IOException{
        //System.setIn(new FileInputStream("res/sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        T = Integer.parseInt(st.nextToken());
        for(int i=0;i<T;i++){
            System.out.print("#"+(i+1)+" ");
            solution(br, st);
        }

    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);

        if(u<x){
            System.out.println(-1);
        }
        else if(l<=x && x<=u){
            System.out.println(0);
        }
        else if(x<l){
            System.out.println(l-x);
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        l = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
    }
}
