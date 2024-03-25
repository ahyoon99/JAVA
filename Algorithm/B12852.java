package Algorithm;

import java.util.*;
import java.io.*;

public class B12852 {
    static int n;
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());

        int[] num = new int[n+1];
        int[] before = new int[n+1];
        Arrays.fill(num, Integer.MAX_VALUE);

        num[1]=0;
        for(int i=2;i<=n;i++){
            if(i%3==0 && num[i]>num[i/3]+1){
                num[i]=num[i/3]+1;
                before[i]=i/3;
            }
            if(i%2==0 && num[i]>num[i/2]+1){
                num[i]=num[i/2]+1;
                before[i]=i/2;
            }
            if(i>1 && num[i]>num[i-1]+1){
                num[i]=num[i-1]+1;
                before[i]=i-1;
            }
        }

        System.out.println(num[n]);
        int number = n;
        for(int i=0;i<=num[n];i++){
            System.out.print(number+" ");
            number = before[number];
        }
        System.out.println();
        
    }
}
