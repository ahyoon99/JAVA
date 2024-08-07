package Algorithm;

import java.util.*;
import java.io.*;

public class swea3131 {
    static public void main(String args[]){
        int n = 1000001;

        boolean[] isPrime = new boolean[n];

        Arrays.fill(isPrime, true);
        
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                for(int j=2*i;j<n;j+=i){
                    isPrime[j]=false;
                }
            }
        }

        for(int i=2;i<n;i++){
            if(isPrime[i]){
                System.out.print(i+" ");
            }
        }
    }

}
