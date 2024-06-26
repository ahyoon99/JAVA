package Algorithm;

import java.util.*;
import java.io.*;

public class swea2817 {
    static int n;
    static int k;
    static int[] num;
    static int answer;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int t = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            solution(br, st);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);
        Arrays.sort(num);
        go(0,0);
        System.out.println(answer);
    }

    static void go(int value, int idx){
        if(value==k){
            answer++;
            return;
        }
        if(idx>=n || value>k){
            return;
        }
        go(value+num[idx], idx+1);
        go(value, idx+1);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        num = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
    }
}
