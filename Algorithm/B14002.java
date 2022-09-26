package Algorithm;

import java.util.*;

public class B14002 {

    // 방법 1 : Bottom up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] num = new int[n];
    //     for(int i=0;i<n;i++){
    //         num[i]=sc.nextInt();
    //     }

    //     int[] distance = new int[n];
    //     Arrays.fill(distance, -1);
    //     distance[0]=1;

    //     int[] idx = new int[n];
    //     Arrays.fill(idx, -1);
        
    //     for(int i=1;i<n;i++){
    //         for(int j=i;j>=0;j--){
    //             if(num[j]<num[i] && distance[i] < distance[j]+1){
    //                 distance[i] = distance[j]+1;
    //                 idx[i]=j;
    //             }
    //         }
    //         if(distance[i]==-1){
    //             distance[i]=1;
    //         }
    //     }
        
    //     int maxLength = 0;
    //     int maxIdx=0;
    //     for(int i=0;i<n;i++){
    //         if(maxLength<distance[i]){
    //             maxLength=distance[i];
    //             maxIdx=i;
    //         }
    //     }

    //     System.out.println(maxLength);
    //     int[] answer = new int[maxLength];

    //     int medIdx=maxIdx;
    //     int cnt=0;
    //     while(true){
    //         answer[cnt]=num[medIdx];
    //         cnt++;
    //         medIdx = idx[medIdx];
    //         if(medIdx==-1){
    //             break;
    //         }
    //     }

    //     Arrays.sort(answer);
    //     for(int i=0;i<maxLength;i++){
    //         System.out.print(answer[i]+" ");
    //     }
    // }
    
    // 방법 2 : Top down
    static int go(int n, int[] num, int[] distance, int[] idx){
        if(distance[n]!=-1){
            return distance[n];
        }
        for(int i=0;i<n;i++){
            int distI = go(i,num, distance, idx);
            if(num[i]<num[n] && distance[n]<distI+1){
                distance[n] = distI+1;
                idx[n]=i;
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
        int[] distance = new int[n];
        int[] idx = new int[n];

        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }

        Arrays.fill(idx, -1);
        Arrays.fill(distance, -1);
        distance[0]=1;

        go(n-1, num, distance, idx);

        int max = -1;
        int startIdx=0;
        for(int i=0;i<n;i++){
            if(max<distance[i]){
                max = distance[i];
                startIdx = i;
            }
        }

        System.out.println(max);

        int[] result = new int[max];
        int i = max-1;
        while(i!=-1){
            result[i] = num[startIdx];
            i--;
            startIdx = idx[startIdx];
        }

        for(int j=0;j<max;j++){
            System.out.print(result[j]+" ");
        }
    }
}
