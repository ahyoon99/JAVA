package Algorithm;

import java.util.Scanner;

public class B15988 {

    // 1. Bottom-up
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] num = new long[1000001];
        num[1]=1;
        num[2]=2;
        num[3]=4;
        for(int i=4;i<=1000000;i++){
            num[i] = (num[i-1]+num[i-2]+num[i-3])%1000000009;
        }
        for(int i=0;i<T;i++){
            int n = sc.nextInt();
            System.out.println(num[n]);
        } 
    }
    
}
