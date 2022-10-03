package Algorithm;

import java.util.*;

public class B11722 {
    // 방법 1 : Bottom up
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[0]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(num[j]>num[i] && distance[i]<distance[j]+1){
                    distance[i]=distance[j]+1;
                }
            }
            if(distance[i]==-1){
                distance[i]=1;
            }
        }
        Arrays.sort(distance);
        System.out.println(distance[n-1]);
    }
}
