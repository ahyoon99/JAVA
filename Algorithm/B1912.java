package Algorithm;

import java.util.*;

public class B1912 {
    // 방법 1 : Bottom up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] num = new int[n];
    //     int[] maxSum = new int[n];
    //     for(int i=0;i<n;i++){
    //         num[i]=sc.nextInt();
    //     }

    //     maxSum[0]=num[0];
    //     for(int i=1;i<n;i++){
    //         if(num[i]<maxSum[i-1]+num[i]){
    //             maxSum[i]=maxSum[i-1]+num[i];
    //         }else{
    //             maxSum[i]=num[i];
    //         }
    //     }
    //     Arrays.sort(maxSum);
    //     System.out.println(maxSum[n-1]);
    // }

    // 방법 2 : Top down
    static int go(int[] num, Integer[] maxSum, int n){
        if(maxSum[n]!=null){
            return maxSum[n];
        }
        int prev = go(num, maxSum, n-1);
        if(num[n]<prev+num[n]){
            maxSum[n]=prev+num[n];
        }
        else{
            maxSum[n]=num[n];
        }
        return maxSum[n];
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        Integer[] maxSum = new Integer[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        Arrays.fill(maxSum,null);

        maxSum[0]=num[0];
        go(num, maxSum, n-1);

        Arrays.sort(maxSum);
        System.out.println(maxSum[n-1]);
    }
}
