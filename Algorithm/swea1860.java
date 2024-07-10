package Algorithm;

import java.io.*;
import java.util.*;

// swea1860 진기의 최고급 붕어빵
public class swea1860 {
    static int T;
    static int n;
    static int m;
    static int k;
    static int[] people;

    static public void main(String args[]) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());

        for(int testcase=1;testcase<=T;testcase++){
            System.out.print("#"+testcase+" ");
            input(br, st);
            solution();
        }

    }

    static void solution(){
        for(int i=0;i<n;i++){
            int period = people[i]/m;
            int cnt = period * k;
            cnt-=i;
            if(cnt<=0){
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        people = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            people[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(people);
    }
}
