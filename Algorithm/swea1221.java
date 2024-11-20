package Algorithm;

import java.util.*;
import java.io.*;

public class swea1221 {
    static int t;
    static int n;
    static HashMap<String, Integer> numbers;
    static String[] alp = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
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
        for(int i=0;i<alp.length;i++){
            if(numbers.containsKey(alp[i])){
                int cnt = numbers.get(alp[i]);
                for(int j=0;j<cnt;j++){
                    System.out.print(alp[i]+" ");
                }
            }
        }
        System.out.println();
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        String com = st.nextToken();
        n = Integer.parseInt(st.nextToken());

        numbers = new HashMap<String, Integer>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            com = st.nextToken();
            if(numbers.containsKey(com)){
                int cnt = numbers.get(com);
                numbers.put(com, cnt+1);
            }
            else{
                numbers.put(com, 1);
            }
        }
    }
}
