package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B1759 {

    // 1. 순열 사용
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
        int l = sc.nextInt();
        int c = sc.nextInt();
        char[] alp = new char[c];
        int[] order = new int[c];
        for(int i=0;i<c;i++){
            alp[i]=sc.next().charAt(0);
        }
        Arrays.sort(alp);

        for(int i=0;i<l;i++){
            order[i]=0;
        }
        for(int i=l;i<c;i++){
            order[i]=1;
        }
        do{
            String pw="";
            int mo_cnt=0;
            int ja_cnt=0;
            for(int i=0;i<c;i++){
                if(order[i]==0){
                    if(alp[i]=='a' || alp[i]=='e' || alp[i]=='i' || alp[i]=='o' || alp[i]=='u' ){
                        mo_cnt++;
                    }
                    else{
                        ja_cnt++;
                    }
                    pw+=alp[i];
                }
            }
            if(mo_cnt>=1 && ja_cnt>=2){
                System.out.println(pw);
            }
        }while(next_permutation(order, c));
    }
}
