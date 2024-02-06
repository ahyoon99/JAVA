package Algorithm;

import java.util.*;
import java.io.*;

public class swea1208 {
    static int n;
    static int[] height;
    static public void main(String args[]) throws Exception{

        System.setIn(new FileInputStream("res/input_swea1208.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case=0;test_case<10;test_case++){
            System.out.print("#"+(test_case+1)+" ");
            solution(br);
        }
        
    }

    static void solution(BufferedReader br) throws Exception{
        input(br);

        for(int i=0;i<n;i++){
            Arrays.sort(height);
            height[0]++;
            height[99]--;
        }
        
        Arrays.sort(height);
        System.out.println(height[99]-height[0]);
    }

    static void input(BufferedReader br) throws Exception{

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        height = new int[100];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<100;i++){
            height[i]=Integer.parseInt(st.nextToken());
        }
        
    }
}
