package Algorithm;

import java.util.*;
import java.io.*;

public class H248372 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());

        int[] height = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            height[i]=Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        for(int i=0;i<n;i++){
            result[i]=1;
        }

        for(int i=1;i<n;i++){
            int max=-1;
            for(int j=0;j<i;j++){
                if(height[j]<height[i] && max<result[j]){
                    result[i]=result[j]+1;
                    max=result[j];
                }
            }
        }
        Arrays.sort(result);
        System.out.println(result[n-1]);
    }
}
