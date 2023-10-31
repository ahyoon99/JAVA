package Algorithm;

import java.util.*;
import java.io.*;

public class swea2007 {
    static String command;
    static public void main(String args[]) throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#"+test_case+" ");
            solution(br, st);
        }
    }

    static public void solution(BufferedReader br, StringTokenizer st) throws Exception{
        input(br, st);

        for(int i=1;i<=10;i++){
            String madi = command.substring(0,i);
            boolean check=true;
            for(int j=0;j<30;j+=madi.length()){
                if(j+madi.length()>=30){
                    continue;
                }
                if(!madi.equals(command.substring(j, j+madi.length()))){
                    check=false;
                    break;
                }
            }
            if(check){
                System.out.println(madi.length());
                break;
            }
        }

    }

    static public void input(BufferedReader br, StringTokenizer st) throws Exception{
        st = new StringTokenizer(br.readLine(), " ");
        command = st.nextToken();


    }
}
