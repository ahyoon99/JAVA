package Algorithm;

import java.util.*;

public class B11053 {
    // 방법 1 : Bottom up
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];

        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0]=1;

        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                if(num[j]<num[i] && answer[i]<answer[j]+1){
                    answer[i] = answer[j]+1;
                }
            }
            if(answer[i]==-1){
                answer[i]=1;
            }
        }
        Arrays.sort(answer);
        System.out.println(answer[n-1]);
    }
    
}
