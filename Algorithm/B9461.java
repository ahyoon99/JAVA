package Algorithm;

import java.util.Scanner;

public class B9461 {
    static public void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        long[] p = new long[101];

        p[0]=1;
        p[1]=1;
        p[2]=1;
        p[3]=2;
        p[4]=2;
        p[5]=3;
        p[6]=4;
        p[7]=5;

        for(int i=8;i<=100;i++){
            p[i]=p[i-5]+p[i-1];
        }

        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            System.out.println(p[n-1]);
        }
    }
    
}
