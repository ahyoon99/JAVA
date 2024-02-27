package Algorithm;

import java.util.*;
import java.io.*;

public class swea20019 {
    static int n;
    static String com;
    static boolean answer;

    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            System.out.print("#"+(i+1)+" ");
            solution(br, st);
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        input(br, st);

        if(com.length()%2==0){
            answer = test(com);
        }
        else if(com.length()%2!=0){
            boolean t1 = test(com);
            boolean t2 = test(com.substring(0,(com.length()-1)/2));
            boolean t3 = test(com.substring((com.length()-1)/2 +1 , com.length()));
                        
            if((t1 && t2) && t3){
                answer = true;
            }
        }
        
        if(answer){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        com = st.nextToken();
        answer = false;
    }

    static boolean test(String str){
        boolean result = true;
        int len = str.length();
        for(int i=0;i<len/2;i++){
            if(str.charAt(i)!=str.charAt(len-i-1)){
                result=false;
                break;
            }
        }
        return result;
    }
}
