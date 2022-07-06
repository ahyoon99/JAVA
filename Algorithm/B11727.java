package Algorithm;

import java.util.Scanner;

public class B11727 {
    // 1. Top-down (재귀)
    static int go(int n, int[] num){
        if(n==1){
            num[1]=1;
        }
        else if(n==2){
            num[2]=3;
        }
        else if(num[n]<=0){
            num[n]=(go(n-1, num)+2*go(n-2,num)) % 10007;
        }
        return num[n];
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n+1];
        System.out.println(go(n,num));
    }
    
}
