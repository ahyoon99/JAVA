package Algorithm;

import java.util.*;
import java.io.*;

public class B2217 {
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] rope = new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            rope[i]=w;
        }

        Arrays.sort(rope);

        int max=-1;
        for(int i=0;i<n;i++){
            if(max<rope[i]*(n-i)){
                max = rope[i]*(n-i);
            }
        }
        System.out.println(max);
    }
}
