package Algorithm;

import java.util.*;
import java.io.*;

public class swea3142 {
    static int t;
    static int n;
    static int m;

    static public void main(String args[]) throws IOException{
        //System.setIn(new FileInputStream("res/sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++){
            System.out.print("#"+(i+1)+" ");
            solution(br, st);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);

        int cnt2 = n-m;
        int cnt1 = m-cnt2;

        System.out.println(cnt1+" "+cnt2);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }
}
