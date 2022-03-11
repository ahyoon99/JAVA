package Algorithm;

import java.util.Scanner;

public class B1182 {

    public static int go(int n, int s, int[] num, int sum, int i){
        if(i>num.length){
            return 0;
        }
        else if(i==num.length){
            if(sum!=s){
                return 0;
            }
            else if(sum==s){
                return 1;
            }
        }
        return go(n,s,num,sum+num[i],i+1)+go(n,s,num,sum,i+1);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }

        int[] arr = new int[n];

        int count = go(n,s,num,0,0);
        if(s==0){
            count-=1;
        }
        System.out.println(count);
    }
    
}
