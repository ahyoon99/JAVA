package Algorithm;

import java.util.*;
import java.io.*;

public class swea1989 {
    static int t;
    static String command;
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
        for(int i=0;i<command.length()/2;i++){
            if(command.charAt(i)!=command.charAt(command.length()-i-1)){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
        return;
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        command = st.nextToken();
    }
}
