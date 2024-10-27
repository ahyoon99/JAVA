package Algorithm;

import java.util.*;
import java.io.*;

public class swea7510 {
    static int t;
    static int n;
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
            System.out.println(result);
        }
    } 

    static void solution(){
        if(n==1){
            return;
        }
        int num = n/2 + 1;
        for(int i=1;i<=num;i++){
            int sum = 0;
            int cur = i;
            while(sum<=n){
                if(sum==n){
                    result++;
                    break;
                }
                sum+=cur;
                cur++;
            }
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        result = 1;
    }
}
