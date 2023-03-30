package Algorithm;

import java.math.BigInteger;
import java.util.*;

public class B10826 {
    // 방법 1 : Top-down
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] fibo = new BigInteger[10001];
        Arrays.fill(fibo, BigInteger.valueOf(-1));
        System.out.println(makeFibo(fibo, n));
    }

    static BigInteger makeFibo(BigInteger[] fibo, int n){
        if(n==0){
            fibo[0]=BigInteger.ZERO;
            return fibo[n];
        }
        else if(n==1){
            fibo[1]=BigInteger.ONE;
            return fibo[n];
        }
        else if(fibo[n]!=BigInteger.valueOf(-1)){
            return fibo[n];
        }
        fibo[n]=makeFibo(fibo,n-2).add(makeFibo(fibo, n-1));
        return fibo[n];
    }
}
