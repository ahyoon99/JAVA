package Algorithm;

import java.util.Scanner;

public class B9095 {

    public static int func(int n){
        if(n==1 || n==0){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        int count = 0;
        for(int i=1;i<=3;i++){
            count+=func(n-i);
        }
        return count;
    }
    

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int n = sc.nextInt();
            System.out.println(func(n));
        }
    }
    
}
