package Algorithm;

import java.util.*;

public class B11047 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] price = new int[n];
        for(int i=0;i<n;i++){
            price[i]=sc.nextInt();
        }

        int answer=0;
        int idx=n-1;
        while(idx>=0){
            if(k==0){
                break;
            }
            if(price[idx]<=k){
                answer += (k/price[idx]);
                k -= (price[idx]*(k/price[idx]));
            }
            idx--;
        }
        System.out.println(answer);
    }
}
