package Algorithm;

import java.util.*;
import java.io.*;

public class swea1926 {
    static String answer;
    static int n;
    public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] answer = new int[1001];
            answer[3]=1;
            answer[6]=1;
            answer[9]=1;

            for(int i=10;i<=1000;i++){
                int prev = i/10;
                int next = i%10;

                int med = answer[prev];
                

                if(next!=0 && next%3==0){
                    med++;
                }
                answer[i]=med;
            }

            // for(int i=0;i<=1000;i++){
            //     if(answer[i]!=0){
            //         System.out.println(i+" : "+answer[i]);
            //     }
            // }
            
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            for(int i=1;i<=n;i++){
                if(answer[i]==0){
                    System.out.print(i+" ");
                }
                else{
                    String temp = "";
                    for(int j=0;j<answer[i];j++){
                        temp+="-";
                    }
                    System.out.print(temp+" ");
                }
            }
	}


    
}
