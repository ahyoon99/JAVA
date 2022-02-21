package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B10972 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        int med1=-1;
        for(int i=n-1;i>0;i--){
            if(arr[i-1]<arr[i]){
                med1=i;
                break;
            }
        }
        if(med1==-1){
            System.out.println("-1");
            return;
        }

        int med2=-1;
        for(int j=n-1;j>=med1;j--){
            if(arr[j]>arr[med1-1]){
                med2 = j;
                break;
            }
        }

        int temp = arr[med1-1];
        arr[med1-1] = arr[med2];
        arr[med2]=temp;

        Arrays.sort(arr, med1, n);  // 배열 일부만 sort
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

    }
    
}
