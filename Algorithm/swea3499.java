package Algorithm;

import java.util.*;
import java.io.*;

public class swea3499 {
    static int t;
    static int n;
    static Queue<String> q1;
    static Queue<String> q2;
    
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
            System.out.println();
        }
    }    

    static void solution(){
        while(true){
            if(q1.isEmpty() || q2.isEmpty()){
                break;
            }
            System.out.print(q1.poll()+" ");
            System.out.print(q2.poll()+" ");
        }

        if(!q1.isEmpty()){
            System.out.print(q1.poll()+" ");
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        q1 = new LinkedList<String>();
        q2 = new LinkedList<String>();

        int mid = -1;
        if(n%2==0){
            mid = n/2;
        }
        else{
            mid = n/2 + 1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<mid;i++){
            q1.add(st.nextToken());
        }
        for(int i=mid;i<n;i++){
            q2.add(st.nextToken());
        }
    }
}
