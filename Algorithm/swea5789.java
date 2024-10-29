package Algorithm;

import java.util.*;
import java.io.*;

public class swea5789 {
    static int t;
    static int n;
    static int q;
    static int[] num;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution(br, st);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        for(int i=1;i<=q;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken())-1;
            int right = Integer.parseInt(st.nextToken())-1;

            for(int j=left;j<=right;j++){
                num[j]=i;
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        num = new int[n];
    }
}
