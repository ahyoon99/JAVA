package Algorithm;

import java.util.*;

public class B11053 {
    // 방법 1 : Bottom up
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] num = new int[n];

    //     for(int i=0;i<n;i++){
    //         num[i]=sc.nextInt();
    //     }

    //     int[] answer = new int[n];
    //     Arrays.fill(answer, -1);
    //     answer[0]=1;

    //     for(int i=1;i<n;i++){
    //         for(int j=i;j>=0;j--){
    //             if(num[j]<num[i] && answer[i]<answer[j]+1){
    //                 answer[i] = answer[j]+1;
    //             }
    //         }
    //         if(answer[i]==-1){
    //             answer[i]=1;
    //         }
    //     }
    //     Arrays.sort(answer);
    //     System.out.println(answer[n-1]);
    // }

    // 방법 2 : Top down
    static int go(int n, int[] num, int[] distance){
        if(distance[n]!=-1){
            return distance[n];
        }
        for(int i=0;i<n;i++){
            int distI = go(i,num, distance);
            if(num[i]<num[n] && distance[n]<distI+1){
                distance[n]=distI+1;
            }
        }
        if(distance[n]==-1){
            distance[n]=1;
        }
        return distance[n];
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[0]=1;

        go(n-1,num, distance);
        
        int max = -1;
        for(int i=0;i<n;i++){
            if(max<distance[i]){
                max = distance[i];
            }
        }
        System.out.println(max);
    }
}
