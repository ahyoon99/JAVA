package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class B1759 {

    // 1. 순열 사용
    // public static boolean next_permutation(int[] arr, int n){
    //     int i = n-1;
    //     while(i>0 && arr[i-1]>=arr[i]){
    //         i--;
    //     }
    //     if(i==0){
    //         return false;
    //     }
    //     int j=n-1;
    //     while(j>0 && arr[i-1]>=arr[j]){
    //         j--;
    //     }

    //     int temp = arr[i-1];
    //     arr[i-1] = arr[j];
    //     arr[j]=temp;

    //     Arrays.sort(arr, i, n);

    //     return true;
    // }
    
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int l = sc.nextInt();
    //     int c = sc.nextInt();
    //     char[] alp = new char[c];
    //     int[] order = new int[c];
    //     for(int i=0;i<c;i++){
    //         alp[i]=sc.next().charAt(0);
    //     }
    //     Arrays.sort(alp);

    //     for(int i=0;i<l;i++){
    //         order[i]=0;
    //     }
    //     for(int i=l;i<c;i++){
    //         order[i]=1;
    //     }
    //     do{
    //         String pw="";
    //         int mo_cnt=0;
    //         int ja_cnt=0;
    //         for(int i=0;i<c;i++){
    //             if(order[i]==0){
    //                 if(alp[i]=='a' || alp[i]=='e' || alp[i]=='i' || alp[i]=='o' || alp[i]=='u' ){
    //                     mo_cnt++;
    //                 }
    //                 else{
    //                     ja_cnt++;
    //                 }
    //                 pw+=alp[i];
    //             }
    //         }
    //         if(mo_cnt>=1 && ja_cnt>=2){
    //             System.out.println(pw);
    //         }
    //     }while(next_permutation(order, c));
    // }

    // 2. 재귀함수 사용
    // n : 만들어야하는 암호의 길이
    // arr : 사용할 수 있는 알파벳
    // pw : 현재까지 만든 암호
    // i : 사용해야할지 말지 결정해야하는 알파벳의 인덱스
    public static void go(int n, char[] arr, String pw, int i){
        if(pw.length()==n){
            int mo=0;
            int ja=0;
            for(int index=0;index<n;index++){
                if(pw.charAt(index)=='a' ||pw.charAt(index)=='e' ||pw.charAt(index)=='i' ||pw.charAt(index)=='o' ||pw.charAt(index)=='u'){
                    mo++;
                }
                else{
                    ja++;
                }
            }
            if(mo>=1 && ja>=2){
                System.out.println(pw);
            }
            return;
        }
        if(i>=arr.length){
            return;
        }
        go(n, arr, pw+arr[i], i+1);
        go(n, arr, pw, i+1);
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();
        char[] alp = new char[c];
        for(int i=0;i<c;i++){
            alp[i]=sc.next().charAt(0);
        }
        Arrays.sort(alp);
        go(l, alp, "",0);
    }
}
