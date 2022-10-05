package Algorithm;

import java.util.*;

public class B11054 {
    // 방법 1 : Bottom up
    static public void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }

        int[] increase = new int[n];
        int[] decrease = new int[n];

        Arrays.fill(increase, -1);
        Arrays.fill(decrease, -1);
        increase[0]=1;
        decrease[0]=1;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(num[j]<num[i] && increase[i]<increase[j]+1){
                    increase[i]=increase[j]+1;
                }
            }
            if(increase[i]==-1){
                increase[i]=1;
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(num[j]<num[i] && decrease[i]<decrease[j]+1){
                    decrease[i]=decrease[j]+1;
                }
            }
            if(decrease[i]==-1){
                decrease[i]=1;
            }
        }

        int max = increase[0]+decrease[0]-1;
        for(int i=0;i<n;i++){
            if(max<increase[i]+decrease[i]-1){
                max=increase[i]+decrease[i]-1;
            }
        }
        System.out.println(max);
    }
    
}
