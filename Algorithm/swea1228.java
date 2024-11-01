package Algorithm;

import java.util.*;
import java.io.*;

public class swea1228 {
    static int n;
    static int m;
    static ArrayList<String> passwords;
    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int testcase=1;testcase<=10;testcase++){
            System.out.print("#"+testcase+" ");
            solution(br);

            for(int i=0;i<10;i++){
                System.out.print(passwords.get(i)+" ");
            }
            System.out.println();
        }
    }

    static void solution(BufferedReader br) throws IOException{
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        passwords = new ArrayList<String>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            passwords.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<m;i++){
            String com = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j=0;j<y;j++){
                String s = st.nextToken();
                passwords.add(x+j, s);
            }
        }
    }
}
