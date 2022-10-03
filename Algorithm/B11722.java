package Algorithm;

import java.util.*;

public class B11722 {
    // 방법 1 : Bottom up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n =sc.nextInt();
    //     int[] num = new int[n];
    //     for(int i=0;i<n;i++){
    //         num[i]=sc.nextInt();
    //     }

    //     int[] distance = new int[n];
    //     Arrays.fill(distance, -1);
    //     distance[0]=1;
    //     for(int i=1;i<n;i++){
    //         for(int j=0;j<i;j++){
    //             if(num[j]>num[i] && distance[i]<distance[j]+1){
    //                 distance[i]=distance[j]+1;
    //             }
    //         }
    //         if(distance[i]==-1){
    //             distance[i]=1;
    //         }
    //     }
    //     Arrays.sort(distance);
    //     System.out.println(distance[n-1]);
    // }

    // 방법 2 : Top down
    static int go(int[] num, int[] distance, int n){
        if(distance[n]!=-1){
            return distance[n];
        }
        for(int i=0;i<n;i++){
            int maxDist = go(num, distance, i);
            if(num[i]>num[n] && distance[n]<maxDist+1){
                distance[n]=maxDist+1;
            }
        }
        if(distance[n]==-1){
            distance[n]=1;
        }
        return distance[n];
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        
        int[] distance = new int[n];
        Arrays.fill(distance,-1);
        distance[0]=1;

        go(num, distance,n-1);
        Arrays.sort(distance);
        System.out.println(distance[n-1]);
    }
}
