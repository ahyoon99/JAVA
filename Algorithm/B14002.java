package Algorithm;

import java.util.*;

public class B14002 {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[0]=1;

        int[] idx = new int[n];
        Arrays.fill(idx, -1);
        
        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                if(num[j]<num[i] && distance[i] < distance[j]+1){
                    distance[i] = distance[j]+1;
                    idx[i]=j;
                }
            }
            if(distance[i]==-1){
                distance[i]=1;
            }
        }
        
        int maxLength = 0;
        int maxIdx=0;
        for(int i=0;i<n;i++){
            if(maxLength<distance[i]){
                maxLength=distance[i];
                maxIdx=i;
            }
        }

        System.out.println(maxLength);
        int[] answer = new int[maxLength];

        int medIdx=maxIdx;
        int cnt=0;
        while(true){
            answer[cnt]=num[medIdx];
            cnt++;
            medIdx = idx[medIdx];
            if(medIdx==-1){
                break;
            }
        }

        Arrays.sort(answer);
        for(int i=0;i<maxLength;i++){
            System.out.print(answer[i]+" ");
        }
    }
    
}
