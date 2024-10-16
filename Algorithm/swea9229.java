package Algorithm;

import java.util.*;
import java.io.*;

public class swea9229 {
    static int t;
    static int n;
    static int m;
    static int[] snacks;
    static int result;
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
        Arrays.sort(snacks);
        for(int i=0;i<n;i++){
            int temp = snacks[n-i-1];
            snacks[n-i-1]=snacks[i];
            snacks[i]=temp;
        }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int weight = snacks[i]+snacks[j];
                if(weight<=m && weight>result) {
                    result = weight;
                }            
            }
        }
        System.out.println(result);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        snacks = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            snacks[i] = Integer.parseInt(st.nextToken());
        }
        
        result = -1;
    }
}
