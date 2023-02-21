package Algorithm;

import java.util.*;

public class B9461 {
    // 방법 1 : Bottom up
    // static public void main(String args[]){
    //     Scanner sc= new Scanner(System.in);
    //     int t = sc.nextInt();
    //     long[] p = new long[101];

    //     p[0]=1;
    //     p[1]=1;
    //     p[2]=1;
    //     p[3]=2;
    //     p[4]=2;
    //     p[5]=3;
    //     p[6]=4;
    //     p[7]=5;

    //     for(int i=8;i<=100;i++){
    //         p[i]=p[i-5]+p[i-1];
    //     }

    //     for(int i=0;i<t;i++){
    //         int n = sc.nextInt();
    //         System.out.println(p[n-1]);
    //     }
    // }
    

    // 방법 2 : Top down
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        long[] result = new long[101];
        Arrays.fill(result, -1);
        result[0]=1;
        result[1]=1;
        result[2]=1;
        result[3]=2;
        result[4]=2;
        result[5]=3;
        result[6]=4;
        result[7]=5;

        go(result, 100);

        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            System.out.println(result[n-1]);
        }
    }

    static long go(long[] result, int n){
        if(result[n]!=-1){
            return result[n];
        }
        result[n] = go(result, n-5) + go(result, n-1);
        return result[n];
    }   
}
