package Algorithm;

import java.util.*;
import java.io.*;

public class swea6190 {
    static int t;
    static int n;
    static int[] num;
    static int result;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            input(br,st);
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    int multiply = num[i]*num[j];
                    if(check(String.valueOf(multiply))){
                        if(result<multiply){
                            result=multiply;
                        }
                    }
                }
            }
            if(result==Integer.MIN_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(result);
            }
        }
    }
    static boolean check(String str){
        int[] strArr = new int[str.length()];
        for(int i=0;i<str.length();i++){
            strArr[i] = str.charAt(i)-'0';
        }

        for(int i=0;i<strArr.length-1;i++){
            if(strArr[i]>strArr[i+1]){
                return false;
            }
        }
        return true;
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        num = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        result = Integer.MIN_VALUE;
    }
}
