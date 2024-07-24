package Algorithm;

import java.util.*;
import java.io.*;

public class swea1986 {
    static int t;
    static int n;
    static int answer;
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
        for(int i=2;i<=n;i++){
            if(i%2==0){
                answer-=i;
            }
            else{
                answer+=i;
            }
        }
        System.out.println(answer);
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        answer=1;
    }
}
