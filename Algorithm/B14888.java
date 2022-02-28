package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B14888 {

    public static boolean next_permutation(int[] arr, int n){
        int i = n-1;
        while(i>0 && arr[i-1]>=arr[i]){
            i--;
        }
        if(i==0){
            return false;
        }
        int j=n-1;
        while(j>0 && arr[i-1]>=arr[j]){
            j--;
        }

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j]=temp;

        Arrays.sort(arr, i, n);

        return true;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] op = new int[n-1];
        for(int i=0;i<n;i++){
            num[i] = sc.nextInt();
        }

        int cnt=0;
        for(int i=0;i<4;i++){
            int op_cnt = sc.nextInt();
            for(int j=0;j<op_cnt;j++){
                op[cnt]=i;
                cnt++;
            }
        }

        int min = 1000000001;
        int max = -1000000001;
        do{
            int result=num[0];
            for(int i=0;i<n-1;i++){
                if(op[i]==0){
                    result+=num[i+1];
                }
                else if(op[i]==1){
                    result-=num[i+1];
                }else if(op[i]==2){
                    result*=num[i+1];
                }else if(op[i]==3){
                    result/=num[i+1];
                }
            }
            if(result<min){
                min=result;
            }
            if(result>max){
                max=result;
            }
        }while(next_permutation(op, n-1));
        
        System.out.println(max);
        System.out.println(min);
    }
    
}
