package Algorithm;

import java.util.*;
import java.io.*;

public class swea1288 {
    static int t;
    static int n;
    static HashSet<Integer> num;
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
        int cur=0;
        while(num.size()<10){
            cur+=n;
            String curStr = String.valueOf(cur);
            for(int i=0;i<curStr.length();i++){
                num.add(curStr.charAt(i)-'0');
            }
        }
        System.out.println(cur);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        num = new HashSet<Integer>();
    }

}
