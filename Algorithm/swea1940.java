package Algorithm;

import java.util.*;
import java.io.*;

public class swea1940 {
    static int t;
    static int n;

    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());
        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            solution(br, st);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        int v = 0;
        int distance = 0;

        for(int tc = 1;tc<=n;tc++){
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());

            if(command==0){
                distance+=v;
            }
            else if(command == 1){
                v += Integer.parseInt(st.nextToken());
                distance+=v;
            }
            else if(command == 2){
                v = Math.max(v-Integer.parseInt(st.nextToken()), 0);
                distance+=v;
            }
        }
        System.out.println(distance);
    }
}
