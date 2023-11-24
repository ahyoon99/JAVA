package Algorithm;

import java.util.Scanner;

public class B1978 {

    public static boolean isPrime(int a){
        if(a<=1){
            return false;
        }
        for(int i=2;i<=a/2;i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cntPrime = 0;

        while(n-->0){
            if(isPrime(sc.nextInt())){
                cntPrime=cntPrime+1;
            }
        }
        System.out.println(cntPrime);
    }
    
}