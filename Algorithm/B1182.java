package Algorithm;

import java.util.Scanner;

public class B1182 {

    // 1. 재귀 사용
    // public static int go(int n, int s, int[] num, int sum, int i){
    //     if(i>num.length){
    //         return 0;
    //     }
    //     else if(i==num.length){
    //         if(sum!=s){
    //             return 0;
    //         }
    //         else if(sum==s){
    //             return 1;
    //         }
    //     }
    //     return go(n,s,num,sum+num[i],i+1)+go(n,s,num,sum,i+1);
    // }
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int s = sc.nextInt();

    //     int[] num = new int[n];
    //     for(int i=0;i<n;i++){
    //         num[i] = sc.nextInt();
    //     }

    //     int[] arr = new int[n];

    //     int count = go(n,s,num,0,0);
    //     if(s==0){
    //         count-=1;
    //     }
    //     System.out.println(count);
    // }

    // 2. 비트마스크 사용
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = sc.nextInt();
        int[] num = new int[n];
        int cnt=0;
        
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        
        int total = (int) Math.pow(2,n);
        for(int i=1;i<total;i++){
            int result = 0;
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    result+=num[j];
                }
            }
            if(result==ans){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
}
