package Algorithm;

import java.util.*;
import java.io.*;

public class swea1234 {
    static int n;
    static String input;
    static String[] remove = {"00","11","22","33","44","55","66","77","88","99"};
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int testcase=1;testcase<=10;testcase++){
            System.out.print("#"+testcase+" ");
            input(br);
            solution();
        }
    }

    static void solution(){
        while(true){
            int before = input.length();
            for(int i=0;i<remove.length;i++){
                input = input.replace(remove[i],"");
            }
            int after = input.length();

            if(before==after){
                break;
            }
        }

        System.out.println(input);
    }

    static void input(BufferedReader br) throws IOException{
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        input = st.nextToken();
    }
}
