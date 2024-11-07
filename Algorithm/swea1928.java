package Algorithm;

import java.util.*;
import java.io.*;

public class swea1928 {
    static int t;
    static String com;
    static HashMap<Character, Integer> alp;
    static public void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        alp = new HashMap<Character, Integer>();
        char c = 'A';
        for(int i=0;i<26;i++){
            alp.put(c, i);
            c++;
        }

        c = 'a';
        for(int i=26;i<52;i++){
            alp.put(c, i);
            c++;
        }

        c = '0';
        for(int i=52;i<62;i++){
            alp.put(c, i);
            c++;
        }

        alp.put('+',62);
        alp.put('/',63);

        t = Integer.parseInt(st.nextToken());
        for(int testcase=1;testcase<=t;testcase++){
            System.out.print("#"+testcase+" ");
            solution(br, st);
            System.out.println();
        }
    }

    static void solution(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        com = st.nextToken();

        String result = "";
        for(int i=0;i<com.length()/4;i++){
            int startIdx = i*4;
            for(int j=startIdx;j<startIdx+4;j++){
                int num = alp.get(com.charAt(j));
                String binary = Integer.toBinaryString(num);

                int cnt = 6-binary.length();
                for(int k=0;k<cnt;k++){
                    binary="0"+binary;
                }
                result+=binary;
            }
        }

        for(int i=0;i<result.length()/8;i++){
            int startIdx = i*8;
            String temp = result.substring(startIdx, startIdx+8);
            int binaryToInteger = Integer.parseInt(temp, 2);
            char c = (char) binaryToInteger;
            System.out.print(c);
        }
    }

}
