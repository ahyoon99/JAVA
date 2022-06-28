package Algorithm;

import java.util.Scanner;

public class B1463 {
    // 1. Bottom-up 방식
    // public static void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] answer = new int[n+1];
    //     answer[1]=0;
    //     for(int i=2;i<=n;i++){
    //         answer[i]=answer[i-1]+1;
    //         if(i%2==0 && answer[i]>answer[i/2]+1){
    //             answer[i]=answer[i/2]+1;
    //         }
    //         if(i%3==0 && answer[i]>answer[i/3]+1){
    //             answer[i]=answer[i/3]+1;
    //         }
    //     }
    //     System.out.println(answer[n]);
    // }

    // 2. Top-down 방식
    static int go(int n, int[] answer){
        if(n==1){
            return 0;
        }
        if(answer[n]>0){
            return answer[n];
        }
        answer[n]=go(n-1, answer)+1;
        if(n%2==0){
            int temp = go(n/2, answer)+1;
            if(answer[n]>temp){
                answer[n]=temp;
            }
        }
        if(n%3==0){
            int temp = go(n/3, answer)+1;
            if(answer[n]>temp){
                answer[n]=temp;
            }
        }
        return answer[n];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answer = new int[n+1];
        System.out.println(go(n,answer));
    }
}
